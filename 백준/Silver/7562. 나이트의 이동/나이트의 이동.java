
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int[][] map;
    static boolean[][] visit;
    static int n,sx,sy,fx,fy,cnt;
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());

            bfs(new Pair(sx, sy));
            sb.append(map[fx][fy] + "\n");
        }
        System.out.println(sb.toString());
    }
    static void bfs(Pair p){
        Queue<Pair> q= new LinkedList<>();
        visit[p.x][p.y] = true;
        q.add(p);

        if(p.x == fx && p.y == fy){
            return ;
        }

        while(!q.isEmpty()){
            Pair r = q.remove();
            int x1 = r.x;
            int y1 = r.y;

            for(int i = 0; i < 8; i++){
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 >= 0 && x2 < n && y2 >= 0 && y2 < n && !visit[x2][y2]){
                    q.add(new Pair(x2, y2));
                    visit[x2][y2] = true;
                    map[x2][y2] = map[x1][y1] + 1;
                }
            }
        }
    }

    public static class Pair {
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Integer first() {
            return x;
        }

        public Integer second() {
            return y;
        }
    }
}
