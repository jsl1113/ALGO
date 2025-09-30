import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int num = queue.poll();
                queue.add(num);
            }

            list.add(queue.poll());
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if(i != list.size() - 1) sb.append(", ");
            else sb.append(">");
        }

        System.out.println(sb);
    }
}