import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == m) {
            System.out.println(1);
            return;
        }

        m = Math.min(m, n - m);

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n-i));
            result = result.divide(BigInteger.valueOf(i+1));
        }

        System.out.println(result);
    }
}
