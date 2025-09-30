import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long rate = (long) Math.floor((double) y * 100 / (double) x);
        long left = 1, right = 1_000_000_000, result = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long newRate = (long) Math.floor((double) (y + mid) * 100 / (double) (x + mid));

            if (newRate > rate) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
