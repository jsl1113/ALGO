import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        search(n, arr);
        if (max == n) {
            System.out.println(max);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, i, j, j + 1, arr);
                search(n, arr);
                swap(i, i, j, j + 1, arr);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, j+1, i, i, arr);
                max = Math.max(search(n, arr), max);
                swap(j, j+1, i, i, arr);
            }
        }

        System.out.println(max);
    }

    public static void swap(int x1, int x2, int y1, int y2, char[][] arr) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    public static int search(int n, char[][] arr) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
