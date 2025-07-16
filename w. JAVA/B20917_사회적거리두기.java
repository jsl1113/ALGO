package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B20917_사회적거리두기 {
    static int n, s, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int start = 1, end = arr[n - 1] - arr[0];
            int answer = 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if(check(mid)) {
                    start = mid + 1;
                    answer = Math.max(answer, mid);
                } else end = mid - 1;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static boolean check(int dist) {
        int cnt = 1;
        int last = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= dist) {
                cnt++;
                last = arr[i];
            }
        }

        return cnt >= s;
    }
}
