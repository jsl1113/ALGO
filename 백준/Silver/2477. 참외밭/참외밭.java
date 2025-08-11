import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[6][2];
        int[] maxHeight = new int[2];
        int[] maxWidth = new int[2];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            if (arr[i][0] == 1 || arr[i][0] == 2) {
                if (maxWidth[0] < arr[i][1]) {
                    maxWidth[0] = arr[i][1];
                    maxWidth[1] = i;
                }
            } else if (arr[i][0] == 3 || arr[i][0] == 4) {
                if (maxHeight[0] < arr[i][1]) {
                    maxHeight[0] = arr[i][1];
                    maxHeight[1] = i;
                }
            }
        }

        int W, H;
        if (maxWidth[1] == 0) H = Math.abs(arr[5][1] - arr[1][1]);
        else if (maxWidth[1] == 5) H = Math.abs(arr[4][1] - arr[0][1]);
        else H = Math.abs(arr[maxWidth[1] + 1][1] - arr[maxWidth[1] - 1][1]);

        if (maxHeight[1] == 0) W = Math.abs(arr[5][1] - arr[1][1]);
        else if (maxHeight[1] == 5) W = Math.abs(arr[4][1] - arr[0][1]);
        else W = Math.abs(arr[maxHeight[1] + 1][1] - arr[maxHeight[1] - 1][1]);

        System.out.println((maxWidth[0] * maxHeight[0] - W * H) * n);
    }
}