import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[19][19];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = new int[3];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    int color = arr[i][j];

                    if (check(i, j, 0, 1, color)) result = new int[]{color, i + 1, j + 1};
                    else if (check(i, j, 1, 0, color)) result = new int[]{color, i + 1, j + 1};
                    else if (check(i, j, 1, 1, color)) result = new int[]{color, i + 1, j + 1};
                    else if (check(i, j, 1, -1, color)) result = new int[]{color, i + 5, j - 3};
                }
            }
        }

        if (result[0] == 0) System.out.println(0);
        else {
            System.out.println(result[0]);
            System.out.println(result[1] + " " + result[2]);
        }
    }

    static boolean check(int x, int y, int dx, int dy, int color) {
        int cnt = 1;

        for (int i = 1; i <= 5; i++) {
            int nx = x + dx * i;
            int ny = y + dy * i;

            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && arr[nx][ny] == color) cnt++;
            else break;
        }

        if (cnt == 5) {
            int prevX = x - dx;
            int prevY = y - dy;
            int nextX = x + dx * 5;
            int nextY = y + dy * 5;

            if ((prevX < 0 || prevX >= 19 || prevY < 0 || prevY >= 19 || arr[prevX][prevY] != color) &&
                    (nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19 || arr[nextX][nextY] != color)) {
                return true;
            }
        }

        return false;
    }
}
