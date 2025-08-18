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

        List<Bag> bags = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bags.add(new Bag(m, v));
        }

        bags.sort((a, b) -> a.m - b.m);

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int idx = 0;
        long answer = 0;

        PriorityQueue<Bag> pq = new PriorityQueue<>((a, b) -> b.v - a.v); // 가치 역순
        for (int i = 0; i < k; i++) {
            while (idx < n && bags.get(idx).m <= arr[i]) {
                Bag cur = bags.get(idx++);
                pq.add(new Bag(cur.m, cur.v));
            }
            if (!pq.isEmpty()) answer += pq.poll().v;
        }

        System.out.println(answer);
    }

    static class Bag {
        int m, v;

        Bag(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "m=" + m +
                    ", v=" + v +
                    '}';
        }
    }
}
