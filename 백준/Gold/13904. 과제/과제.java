import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> b.d - a.d);

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Task(d, w));
        }

        int answer = 0;
        PriorityQueue<Task> pqueue = new PriorityQueue<>((a, b) -> b.w - a.w);
        for (int i = 1001; i > 0; i--) {
            if(!pq.isEmpty()){
                while (!pq.isEmpty() && pq.peek().d >= i) {
                    pqueue.add(pq.poll());
                }
            }

            if(pqueue.isEmpty()) continue;
            Task task = pqueue.poll();
            answer += task.w;
        }

        System.out.println(answer);
    }

    static class Task {
        int d, w;

        Task(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }
}
