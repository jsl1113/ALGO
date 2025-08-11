import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }

        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if(check(x, y, i)){
                    arr[x][y] = i;
                    dfs(x, y + 1);
                }
            }
            arr[x][y] = 0;
            return;
        }

        dfs(x, y + 1);
    }

    static boolean check(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if(arr[x][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == num) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[x / 3 * 3 + i][y / 3 * 3 + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
