import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] cost = new int[n];
        int[] degree = new int[n];
        int[] answer = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            degree[i] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < degree[i]; j++) {
                list[Integer.parseInt(st.nextToken()) - 1].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
                answer[i] = cost[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : list[current]) {
                answer[next] = Math.max(answer[next], answer[current] + cost[next]);
                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(answer).max().orElse(0));
    }
}