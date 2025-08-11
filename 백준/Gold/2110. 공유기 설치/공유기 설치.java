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
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

         Arrays.sort(arr);
        int start = 1, end = arr[arr.length - 1] - arr[0];
        long answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;  // 공유기 개수
            int num = arr[0];  // 최근에 설치한 공유기 번호
            for (int i = 1; i < n; i++) {
                if(arr[i] - num < mid) continue;

                cnt++;
                num = arr[i];
            }

            if (cnt < c) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}
