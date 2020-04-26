
import java.util.*;
import java.time.*;
public class Main
{
    static class Pair{
		int count;
		LocalDateTime timeStamp;
		Pair(int count){
			this.count =count;
			// every time this is called, latest current time would be updated.
			this.timeStamp = LocalDateTime.now();	
		}
	}
	// map of customer ID as key and count, TimeStamp as value
	private static HashMap<Integer, Pair> requestMap= new HashMap<Integer,Pair>();
	
	private static int timeLimit =2;
	private static int maxRequest=10;

	public static boolean rateLimiter(int customerId){
		if(requestMap.containsKey(customerId)){
			Pair reqData = requestMap.get(customerId);
			//get the time duration gap between the current time and the saved time
			Duration duration = Duration.between(reqData.timeStamp,  LocalDateTime.now());
			if(duration.getSeconds()<=timeLimit){
				//increment count
				//System.out.println(reqData.count);
				if(reqData.count<maxRequest){
				    requestMap.put(customerId, new Pair(reqData.count+1)); 
                    return true;
				}else{
				    requestMap.put(customerId, new Pair(0));
				    return false;
				}
				
            }else{
                //reset the request counter if timer is done
                if(duration.getSeconds()>timeLimit){
                    requestMap.put(customerId, new Pair(0));
                }
                return false;
            }
        }else{
            //update the map with customer id and give the count as 1 (starting count)
            requestMap.put(customerId, new Pair(1));
            return true;
        }
    }
	public static void main(String[] args) {
	    for(int i=0;i<4;i++){
            System.out.println("Customer ID 12345 "+ (rateLimiter(12345)?"Proceed":"Max Limit"));
			System.out.println("Customer ID 23456 "+ (rateLimiter(23456)?"Proceed":"Max Limit"));

			try {
				Thread.sleep(2000);
			} 
			catch(InterruptedException e){
			}
			System.out.println("Customer ID 12345 "+ (rateLimiter(12345)?"Proceed":"Max Limit"));
			System.out.println("Customer ID 23456 "+ (rateLimiter(23456)?"Proceed":"Max Limit"));
        }
	}
}

