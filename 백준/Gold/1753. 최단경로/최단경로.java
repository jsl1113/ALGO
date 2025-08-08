import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e, k;
    static List<Node>[] list;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        list = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        answer = new int[v + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[k] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Node(k, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if(answer[node.v] < node.w) continue;

            for (int i = 0; i < list[node.v].size(); i++) {
                Node tmp = list[node.v].get(i);
                int next = tmp.v;
                int weight = tmp.w;

                if(answer[next] <= answer[node.v] + weight) continue;

                answer[next] = answer[node.v] + weight;
                pq.add(new Node(next, answer[next]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(answer[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(answer[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Node {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}