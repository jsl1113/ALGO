import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][][] visited; 
    static int[][][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Node dochi, stop;
    static ArrayList<Node> waters = new ArrayList<>(); 

    public static class Node {
        int y, x, flag;
        Node(int y, int x, int flag) {
            this.y = y;
            this.x = x;
            this.flag = flag; 
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (Node water : waters) {
            queue.add(water);
        }

        queue.add(dochi); 
        visited[stop.y][stop.x][1] = true; 
        dist[stop.y][stop.x][1] = 999999;

        while(!queue.isEmpty()) {
            Node e = queue.poll();
            visited[e.y][e.x][e.flag] = true;
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + e.x;
                int ny = dy[i] + e.y;
                if(nx < 0 || ny < 0 || nx >= C || ny >= R) {
                    continue;
                }
                if(visited[ny][nx][e.flag]) {
                    continue;
                }
                if(map[ny][nx] == 'X' || map[ny][nx] == '*') {
                    continue; 
                }
                if(e.flag == 0) { 
                    if(visited[ny][nx][1] && (dist[e.y][e.x][0] + 1 >= dist[ny][nx][1])) {
                        continue;
                    }
                }
                dist[ny][nx][e.flag] = dist[e.y][e.x][e.flag] + 1;
                visited[ny][nx][e.flag] = true;
                queue.add(new Node(ny, nx, e.flag));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C][2];
        dist = new int[R][C][2];
        for(int j = 0; j < R; j++) {
            String input = br.readLine();
            for(int i = 0; i < C; i++) {
                map[j][i] = input.charAt(i);
                if(map[j][i] == 'S') { 
                    dochi = new Node(j, i, 0);
                } else if (map[j][i] == '*') {
                    waters.add(new Node(j, i, 1));
                } else if (map[j][i] == 'D') { 
                    stop = new Node(j, i, -1);
                }
            }
        }

        bfs();

        if(dist[stop.y][stop.x][0] != 0) { 
            System.out.println(dist[stop.y][stop.x][0]);
        } else {
            System.out.println("KAKTUS");
        }
    }
}
