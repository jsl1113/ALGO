import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        init(arr);

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 0) sb.append(dp[end][c - 'a']);
            else sb.append(dp[end][c - 'a'] - dp[start - 1][c - 'a']);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void init(char[] arr) {
        dp = new int[arr.length][26];
        dp[0][arr[0] - 'a'] = 1;
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i] - 'a';

            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][num]++;
        }
    }
}