package com.company;

import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        int[] arr = new int[n];
        Arrays.fill(arr, 121);
        arr[0] = 0;

        for (int i = 0; i < info.length; i++) {
            for (int j = n - 1; j >= 0; j--) {
                arr[j] += info[i][1];

                if (j - info[i][0] < 0) continue;
                arr[j] = Math.min(arr[j], arr[j - info[i][0]]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < m) return i;
        }

        return -1;
    }
}