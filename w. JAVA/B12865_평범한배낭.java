package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Bag[] arr = new Bag[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i].w; j--) {
                dp[j] = Math.max(dp[j], arr[i].v + dp[j - arr[i].w]);
            }
        }

        System.out.println(dp[k]);
    }

    static class Bag {
        int w, v;

        Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
