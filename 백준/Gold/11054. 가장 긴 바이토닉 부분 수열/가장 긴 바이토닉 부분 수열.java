import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpL = new int[n];
        int[] dpR = new int[n];
        for (int i = 0; i < n; i++) {
            dpL[i] = 1;
            dpR[i] = 1;
        }

        // 왼 -> 오
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dpL[i] = Math.max(dpL[j] + 1, dpL[i]);
            }
        }

        // 오 -> 왼
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) dpR[i] = Math.max(dpR[j] + 1, dpR[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dpL[i] + dpR[i] - 1);
        }
        System.out.println(answer);
    }
}