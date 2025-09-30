import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][2 * n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                arr[i][j] = ' ';
            }
        }

        func(0, n - 1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void func(int x, int y, int n) {
        if (n == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = arr[x + 2][y + 2] = '*';
            arr[x + 2][y - 1] = arr[x + 2][y + 1] = '*';
            arr[x + 2][y] = '*';
            return;
        }

        func(x, y, n / 2);
        func(x + n / 2, y - n / 2, n / 2);
        func(x + n / 2, y + n / 2, n / 2);
    }
}