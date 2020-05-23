import java.util.*;
import java.util.Arrays;
public class Main{
  public static int[] A;
  
  public static int[] dp;
  
  public static int solve(int i, int N){
    if(i == N) return 0;
    if(dp[i]!=-1) return dp[i];
    int cost =0;
    if( (i+1)<=N){
        cost= Math.abs(A[i]-A[i+1]) + solve(i+1,N);
    }
    if( (i+2)<=N){
        cost= Math.min(cost, Math.abs(A[i]-A[i+2])  + solve(i+2,N)); 
    }
    dp[i] = cost;
    return cost;
  }

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    
    int N = s.nextInt();
    A = new int[N];
    dp = new int[N];
    Arrays.fill(dp, -1);
    
    for(int i=0;i<N;i++){
     	A[i]=s.nextInt(); 
    }
    
    System.out.println(solve(0,N-1));
  }
}