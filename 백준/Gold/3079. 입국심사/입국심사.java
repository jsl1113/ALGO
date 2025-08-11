import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            min = Math.min(min, arr[i]);
        }

        long start = min, end = min * m;
        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);
            }

            if (sum >= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
