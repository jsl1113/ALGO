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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();

        while (start <= end) {
            int mid = (start + end) / 2;  // 가능한 블루레이 크기

            int cnt = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if(sum != 0) cnt++;

            if(cnt <= m) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(start);
    }
}
