import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        long start = 0, end = arr[n - 1];
        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }

            if (sum <= m) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}
