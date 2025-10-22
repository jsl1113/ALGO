import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int s, answer = Integer.MAX_VALUE;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        dp = new int[s + 1][s * 2 + 1];
        for (int i = 0; i <= s; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dfs(0, 1, 0);
        System.out.println(answer);
    }

    static void dfs(int cnt, int emotion, int copy) {
        if(dp[copy][emotion] <= cnt) return;
        dp[copy][emotion] = cnt;
        
        if (cnt >= answer) return;
        if (emotion == s) {
            answer = Math.min(answer, cnt);
            return;
        } else if (emotion > s) {
            answer = Math.min(answer, cnt + (emotion - s));
            return;
        }

        dfs(cnt + 2, 2 * emotion, emotion);
        if (copy != 0) dfs(cnt + 1, emotion + copy, copy);
        if (emotion > 1) dfs(cnt + 1, emotion - 1, copy);
    }
}
