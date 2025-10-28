import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n * n; i++) {
            for (int j = i; j < n * n; j++) {
                for (int k = j; k < n * n; k++) {
                    if (isBeFlower(i, j) && isBeFlower(j, k) && isBeFlower(k, i)) {
//                        System.out.println(i + " " + j + " " + k);
                        minCost = Math.min(calCost(i) + calCost(j) + calCost(k), minCost);
                    }
                }
            }
        }

        System.out.println(minCost);
    }

    private static int calCost(int num){
        int i = num / n;
        int j = num % n;
        return arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i + 1][j] + arr[i][j + 1];
    }

    private static boolean isBeFlower(int i, int j) {
        if (i / n == 0 || i / n == n - 1) return false;
        if (j / n == 0 || j / n == n - 1) return false;

        if (i % n == 0 || i % n == n - 1) return false;
        if (j % n == 0 || j % n == n - 1) return false;

        if ((Math.abs(j / n - i / n) == 2) && (i % n == j % n)) return false;
        else if ((Math.abs(j / n - i / n) < 2) && (Math.abs(i % n - j % n) < 2)) return false;
        else if ((i / n == j / n) && (Math.abs(i % n - j % n) < 3)) return false;

        return true;
    }
}