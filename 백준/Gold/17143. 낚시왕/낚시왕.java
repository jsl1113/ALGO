import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, m;
    static Shark[][] arr;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Shark[r + 1][c + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            d = d == 1 ? 0 : d;
            d = d == 4 ? 1 : d;
            arr[x][y] = new Shark(x, y, s, d, z);
        }

        int answer = 0;
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= r; j++) {
                if (arr[j][i] != null) {
                    answer += arr[j][i].z;
                    arr[j][i] = null;
                    break;
                }
            }

            bfs();
        }

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Shark> queue = new LinkedList<>();
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (arr[i][j] == null) continue;
                queue.add(new Shark(i, j, arr[i][j].s, arr[i][j].d, arr[i][j].z));
            }
        }

        arr = new Shark[r + 1][c + 1];

        while (!queue.isEmpty()) {
            Shark shark = queue.poll();

            int speed = shark.s;
            speed = (shark.d != 0 && shark.d != 2) ? speed : speed % ((r - 1) * 2);
            speed = (shark.d == 1 || shark.d == 3) ? speed % ((c - 1) * 2) : speed;

            for (int i = 0; i < speed; i++) {
                int x = shark.r + dx[shark.d];
                int y = shark.c + dy[shark.d];

                if(x <= 0 || x > r || y <= 0 || y > c) {
                    shark.r -= dx[shark.d];
                    shark.c -= dy[shark.d];
                    shark.d = (shark.d + 2) % 4;
                    continue;
                }

                shark.r = x;
                shark.c = y;
            }

            if(arr[shark.r][shark.c] != null) {
                if (arr[shark.r][shark.c].z < shark.z) {
                    arr[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
                }
            } else {
                arr[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
            }
        }
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
