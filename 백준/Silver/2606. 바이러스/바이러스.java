import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = true;
            arr[end][start] = true;
        }
        
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= n; i++) {
                if(!visited[i] && arr[node][i]){
                    queue.add(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
