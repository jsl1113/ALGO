import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long cnt = n - 1;
        long total = cnt + (cnt * (cnt - 1));

        StringBuilder sb = new StringBuilder();
        sb.append(total).append("\n");

        for (int i = 2; i <= n; i++) {
            sb.append("1 ").append(i).append("\n");
        }

        System.out.print(sb);
    }
}
