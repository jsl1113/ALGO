import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        int R = 3, C = 3;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1;
        for (int l = 0; l <= 100; l++) {
            if (arr[r][c] == k) {
                time = l;
                break;
            }

            if (R >= C) {
                int newC = 0;
                for (int i = 0; i < R; i++) {
                    PriorityQueue<Pair> q1 = new PriorityQueue<Pair>();

                    int[] numCnt = new int[101];
                    for (int j = 0; j < C; j++) {
                        numCnt[arr[i][j]]++;
                        arr[i][j] = 0;
                    }

                    for (int m = 1; m < 101; m++) {
                        if (numCnt[m] > 0) {

                            q1.add(new Pair(numCnt[m], m));
                        }
                    }

                    int index = 0;
                    while (!q1.isEmpty()) {
                        arr[i][index++] = q1.peek().num;
                        arr[i][index++] = q1.peek().cnt;
                        q1.remove();
                    }

                    if (newC < index) newC = index;
                }
                C = newC;
            } else {
                int newR = 0;
                for (int i = 0; i < C; i++) {
                    PriorityQueue<Pair> q1 = new PriorityQueue<Pair>();

                    int[] numCnt = new int[101];
                    for (int j = 0; j < R; j++) {
                        numCnt[arr[j][i]]++;
                        arr[j][i] = 0;
                    }
                    for (int m = 1; m < 101; m++) {
                        if (numCnt[m] != 0) {
                            q1.add(new Pair(numCnt[m], m));
                        }
                    }

                    int index = 0;
                    while (!q1.isEmpty()) {
                        Pair p = q1.poll();
                        arr[index++][i] = p.num;
                        arr[index++][i] = p.cnt;
                    }

                    if (newR < index) newR = index;
                }
                R = newR;
            }
        }

        System.out.println(time);
    }

    static class Pair implements Comparable<Pair> {
        int cnt, num;

        Pair(int cnt, int num) {
            this.cnt = cnt;
            this.num = num;
        }

        public int compareTo(Pair o) {
            if (this.cnt > o.cnt) {
                return 1;
            } else if (this.cnt == o.cnt) {
                return this.num - o.num;
            } else {
                return -1;
            }
        }
    }
}
