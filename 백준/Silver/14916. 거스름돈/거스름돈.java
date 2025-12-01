import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long cnt = n / 5;
        long num = n % 5;

        if (num != 0) {
            while (num % 2 != 0) {
                num += 5;
                cnt -= 1;

                if (num > n) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        cnt += num / 2;
        System.out.println(cnt);
    }
}
