import java.util.Arrays;
class Solution {
     int dpMin[][] ,dpMax[][];

    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        dpMin = new int[n + 1][n + 1];
        dpMax = new int[n + 1][n + 1];
        char operArr[] = new char[n];
        int numArr[] = new int[n + 1];

        int arrNum = 0, operNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) numArr[++arrNum] = Integer.parseInt(arr[i]);
            else operArr[++operNum] = arr[i].charAt(0);
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dpMax[i], Integer.MIN_VALUE);
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);
            dpMax[i][i] = numArr[i];
            dpMin[i][i] = numArr[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j + i <= n; j++) {
                for (int k = j; k < (j + i); k++) {
                    calculate(i, j, k, operArr[k]);
                }
            }
        }
        return dpMax[1][n];
    }

    public void calculate(int i, int j, int k, char oper){
        if(oper == '+'){
            dpMax[j][j + i] = Math.max(dpMax[j][k] + dpMax[k + 1][j + i], dpMax[j][j + i]);
            dpMin[j][j + i] = Math.min(dpMin[j][k] + dpMin[k + 1][j + i], dpMin[j][j + i]);
        } else {
            dpMax[j][j + i] = Math.max(dpMax[j][j + i], dpMax[j][k] - dpMin[k + 1][j + i]);
            dpMin[j][j + i] = Math.min(dpMax[j][j + i], dpMin[j][k] - dpMax[k + 1][j + i]);
        }
    }
}