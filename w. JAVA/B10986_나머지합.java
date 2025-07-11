package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이중 for문 없애야 함 O(n) 으로
public class B10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        int[] cnt = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i == 0) arr[i] = num;
            else arr[i] = arr[i - 1] + num;

            cnt[(int) (arr[i] % m)]++;
        }

        long answer = cnt[0];
        for (int i = 0; i < m; i++) {
            // 그 나머지 케이스끼리도 조합(Combination)해야 한다
            answer += cnt[i] < 2 ? 0 : ((long) cnt[i] * (cnt[i] - 1) / 2);
        }

        System.out.println(answer);
    }

    static long comb(long n) {
        if (n < 2) return 0;
        return n * (n - 1) / 2;
    }
}