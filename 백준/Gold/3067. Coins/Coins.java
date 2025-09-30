import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue).toArray();
            int cost = Integer.parseInt(br.readLine());
            System.out.println(solution(n, arr, cost));
        }
    }

    static int solution(int n, int[] arr, int cost) {
        int[] dp = new int[10010];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= cost; j++) {
                if(j - arr[i] < 0) continue;
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[cost];
    }
}
