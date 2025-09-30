import java.io.*;
import java.util.*;

class Main {
  static Integer[][] dp = new Integer[41][2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for(int i = 0; i < t; i++){
      int n = Integer.parseInt(br.readLine());
      fib(n);
      sb.append(dp[n][0] + " " + dp[n][1] + "\n");
    }

    System.out.println(sb.toString());
  }

  static Integer[] fib(int n){
    if(dp[n][0] == null || dp[n][1] == null){
      dp[n][0] = fib(n-1)[0] + fib(n-2)[0];
      dp[n][1] = fib(n-1)[1] + fib(n-2)[1];
    }
    return dp[n];
  }
}