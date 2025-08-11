import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int[] answer = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int mid = i;
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                long sum = arr[start] + arr[mid] + arr[end];
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer[0] = mid;
                    answer[1] = start;
                    answer[2] = end;
                }

                if(sum == 0) break;
                else if(sum > 0) end--;
                else start++;
            }
        }

        Arrays.sort(answer);
        System.out.println(arr[answer[0]] + " " + arr[answer[1]] + " " + arr[answer[2]]);
    }
}
