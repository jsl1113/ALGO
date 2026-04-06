import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long bal = 0, gcd = 0, minBal = Long.MAX_VALUE;
        boolean valid = true;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long delta  = Long.parseLong(st.nextToken()); // 잔액 변화량
            long after  = Long.parseLong(st.nextToken()); // 거래 후 잔액

            if (bal + delta < 0) {
                long charge = after - delta - bal;

                if (after != 0) minBal = Math.min(minBal, after);

                gcd = (gcd == 0) ? charge : GCD(gcd, charge);

                if (gcd <= minBal && minBal != Long.MAX_VALUE) valid = false;
            } else {
                if (bal + delta != after) valid = false;
            }

            bal = after;
        }

        if (!valid) System.out.println(-1);
        else if (gcd == 0) System.out.println(1);
        else System.out.println(gcd);
    }

    static long GCD(long a, long b) {
        return (b == 0) ? a : GCD(b, a % b);
    }
}
