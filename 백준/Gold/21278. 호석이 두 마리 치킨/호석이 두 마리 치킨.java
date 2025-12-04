import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, min;
    static int a, b;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = 101;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i == j || j == k) continue;
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        min = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        dfs(1, 0, new ArrayList<>());
        System.out.println(a + " " + b + " " + min);
    }

    public static void dfs(int start, int cnt, List<Integer> list) {
        if (cnt == 2) {
            int sum = getSum(list);
            if (min > sum) {
                min = sum;
                a = list.get(0);
                b = list.get(1);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(i + 1, cnt + 1, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) continue;
            int tmp = Math.min(arr[i][list.get(0)], arr[i][list.get(1)]) * 2;
            sum += tmp;
        }

        return sum;
    }
}
