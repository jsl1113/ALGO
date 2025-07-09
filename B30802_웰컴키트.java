package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < 6; i++) {
            answer += arr[i] % t == 0 ? arr[i] / t : arr[i] / t + 1;
        }

        System.out.println(answer);
        System.out.println(n / p + " " + n % p);
    }
}
