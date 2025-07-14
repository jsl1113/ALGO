package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String[] result = new String[10_001];
            boolean[] visited = new boolean[10_001];
            Queue<Integer> queue = new LinkedList<>();

            Arrays.fill(result, "");
            queue.add(a);
            visited[a] = true;

            while (!queue.isEmpty() && !visited[b]) {
                int curr = queue.poll();

                int D = (curr * 2) % 10_000;
                int S = (curr == 0) ? 9999 : curr - 1;
                int L = (curr % 1000) * 10 + (curr / 1000);
                int R = (curr % 10) * 1000 + (curr / 10);

                if (!visited[D]) {
                    visited[D] = true;
                    queue.add(D);
                    result[D] = result[curr] + "D";
                }
                if (!visited[S]) {
                    visited[S] = true;
                    queue.add(S);
                    result[S] = result[curr] + "S";
                }
                if (!visited[L]) {
                    visited[L] = true;
                    queue.add(L);
                    result[L] = result[curr] + "L";
                }
                if (!visited[R]) {
                    visited[R] = true;
                    queue.add(R);
                    result[R] = result[curr] + "R";
                }
            }

            sb.append(result[b]).append('\n');
        }

        System.out.println(sb);
    }
}
