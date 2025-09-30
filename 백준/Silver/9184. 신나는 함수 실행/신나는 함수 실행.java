import java.io.*;
import java.util.*;

class Main {
  static int[][][] dp = new int[51][51][51];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while(true){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      
      if(x == -1 && y == -1 && z == -1) break;
      
      sb.append("w(" + x + ", " + y + ", " + z + ") = " + w(x, y, z) + "\n");      
    }

    System.out.println(sb.toString());

    // System.out.println(sb.toString());
  }

  static int w(int a, int b, int c){
    if(0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && dp[a][b][c] != 0){
        return dp[a][b][c];
    }

    if(a <= 0 || b <= 0 || c <= 0){
      return 1;
    }

    if(a > 20 || b > 20 || c > 20){
      return dp[a][b][c] = w(20, 20, 20);
    }

    if(a < b && b < c){
      return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    }
    
    return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
  }

  
}