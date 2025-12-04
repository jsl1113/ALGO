import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[10][10];
    static int answer = -1;
    static int[] square = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int x, int y, int cnt) {
        if (x > 9) {
            dfs(0, y + 1, cnt);
            return;
        }

        if (y > 9) {
            if (answer == -1) answer = cnt;
            else if (answer > cnt) answer = cnt;
            return;
        }

        if (arr[y][x] == 0) {
            dfs(x + 1, y, cnt);
            return;
        }

        for (int i = 5; i >= 1; i--) {
            if (square[i] != 0 && y + i <= 10 && x + i <= 10) {
                if (isSquare(x, y, i)) {
                    check(x, y, i, 0);
                    dfs(x + i, y, cnt + 1);
                    check(x, y, i, 1);
                }
            }
        }
    }

    static boolean isSquare(int x, int y, int i) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if (arr[y + j][x + k] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void check(int x, int y, int i, int use) {
        if (use == 1) square[i]++;
        else square[i]--;

        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                arr[y + j][x + k] = use;
            }
        }
    }
}
