package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

// 1% 에서 틀렸습니다
public class B9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Object[]> queue = new LinkedList<>();
            queue.add(new Object[]{a, ""});
            boolean[] visited = new boolean[10_001];
            visited[a] = true;

            while (!queue.isEmpty()) {
                Object[] curr = queue.poll();

                int next = (int) curr[0];
                String str = (String) curr[1];

                if(next == b){
                    sb.append(str).append("\n");
                    break;
                }

                int D = (next * 2) % 10_000;
                int S = next == 0 ? 9999 : next - 1;
                int L = (next % 1000 / 10) + (next / 1000);
                int R = (next % 10 * 1000) + (next / 10);

                if(!visited[D]){
                    visited[D] = true;
                    queue.add(new Object[]{D, str + "D"});
                }
                if(!visited[S]){
                    visited[S] = true;
                    queue.add(new Object[]{S, str + "S"});
                }
                if(!visited[L]){
                    visited[L] = true;
                    queue.add(new Object[]{L, str + "L"});
                }
                if(!visited[R]){
                    visited[R] = true;
                    queue.add(new Object[]{R, str + "R"});
                }
            }
        }

        System.out.println(sb);
    }
}
