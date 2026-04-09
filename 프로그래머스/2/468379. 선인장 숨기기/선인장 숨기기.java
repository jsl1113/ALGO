import java.util.*;

class Solution {
    private static final int NO_DROP = Integer.MAX_VALUE;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] dropTime = buildDropTimeGrid(m, n, drops);

        int left = 0, right = drops.length;
        int[] answer = {0, 0};

        while (left <= right) {
            int mid = (left + right) / 2;
            int[] safePos = findTopLeftSafePosition(m, n, h, w, dropTime, mid);

            if (safePos != null) {
                answer = safePos;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
    
    private int[][] buildDropTimeGrid(int m, int n, int[][] drops) {
        int[][] dropTime = new int[m][n];
        for (int[] row : dropTime) Arrays.fill(row, NO_DROP);

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            if (dropTime[r][c] == NO_DROP) {
                dropTime[r][c] = i;
            }
        }
        
        return dropTime;
    }
    
    private int[] findTopLeftSafePosition(int m, int n, int h, int w, int[][] dropTime, int K) {
        int[][] prefixSum = buildPrefixSum(m, n, dropTime, K);

        for (int i = h; i <= m; i++) {
            for (int j = w; j <= n; j++) {
                int contaminatedCount = prefixSum[i][j]
                        - prefixSum[i - h][j]
                        - prefixSum[i][j - w]
                        + prefixSum[i - h][j - w];

                if (contaminatedCount == 0) {
                    return new int[]{i - h, j - w};
                }
            }
        }
        
        return null;
    }
    
    private int[][] buildPrefixSum(int m, int n, int[][] dropTime, int K) {
        int[][] prefixSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int isContaminated = (dropTime[i][j] < K) ? 1 : 0;
                prefixSum[i + 1][j + 1] = isContaminated
                        + prefixSum[i][j + 1]
                        + prefixSum[i + 1][j]
                        - prefixSum[i][j];
            }
        }
        
        return prefixSum;
    }
}