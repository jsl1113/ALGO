import java.io.*;
import java.util.*;

class Main {
  static final int INF = (int) 1e9;
  static int[][] g = new int[101][101];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < 101; i++) {
      Arrays.fill(g[i], INF);
    }
    
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        if(i == j) g[i][j] = 0;
      }
    }

    
    for(int i = 0; i < m; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      g[a][b] = Math.min(g[a][b], c);
    }
    
    for(int k = 1; k <= n; k++){
      for(int a = 1; a <= n; a++){
        for(int b = 1; b <= n; b++){
          g[a][b] = Math.min(g[a][b], g[a][k] + g[k][b]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int a = 1; a <= n; a++){
      for(int b = 1; b <= n; b++){
        if(g[a][b] == INF) g[a][b] = 0;
        sb.append(g[a][b] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}

  