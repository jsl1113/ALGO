import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb);
    }

    static void dfs(int num, int cnt) {
        if (cnt == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            if(isPrime(num * 10 + i)) {
                dfs(num * 10 + i, cnt + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}