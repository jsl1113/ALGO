package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9019_DSLR {
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[10_001];
            answer = Integer.MAX_VALUE;
            s = "";
            
            dfs(b, a, 0, "");
            System.out.println("answer = " + answer);
            System.out.println("s = " + s);
        }
    }

    static void dfs(int n, int a, int cnt, String str) {
        if (n > 10_000 || n <= 0) return;

        if (n == a) {
            if (answer > cnt) {
                answer = cnt;
                s = str;
            }
            return;
        }

        visited[n] = true;

        int d = (n / 2) % 10_000;
        System.out.println("d = " + d);
        dfs(d, a, cnt + 1, str + "D");

        int s = n + 1;
        System.out.println("s = " + s);
        dfs(s, a, cnt + 1, str + "S");

        int l = ((n % 10) * 1000) + (n / 10);
        System.out.println("l = " + l);
        dfs(l, a, cnt + 1, str + "L");

        int r = ((n % 1000) * 10) + (n / 1000);
        System.out.println("r = " + r);
        dfs(r, a, cnt + 1, str + "R");

        visited[n] = false;
    }
}
