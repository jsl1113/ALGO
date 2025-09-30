
import java.io.*;
import java.util.*;


public class Main {
    static int n, m, ans;
    static int[][] map, visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visit = new int[n][m];

        for(int i = 0; i < n; i++){
            s = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(s[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        ans = Integer.MAX_VALUE;
        bfs(0,0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void bfs(int y, int x){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x, 1, 0));
        visit[y][x] = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.y  == n-1 && p.x == m-1){
                ans = p.dis;
                break;
            }

            for(int i = 0; i < 4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if(visit[ny][nx] > p.cnt) {
                        if(map[ny][nx] == 0) {
                            visit[ny][nx] = p.cnt;
                            q.add(new Pair(ny, nx, p.dis+1, p.cnt));
                        }
                        else {
                            if(p.cnt == 0){
                                visit[ny][nx] = p.cnt + 1;
                                q.add(new Pair(ny, nx, p.dis+1, p.cnt+1));
                            }
                        }
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        int dis;
        int cnt; // 공사 횟수

        public Pair(int y, int x, int dis, int cnt){
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.cnt = cnt;
        }
    }
}