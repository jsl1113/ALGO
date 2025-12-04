import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int start = 0, end = n - 1, answer = 0;
        while (start <= end) {
            answer = Math.max((end - start - 1) * Math.min(arr[start], arr[end]), answer);

            if(arr[start] < arr[end]) start++;
            else end--;
        }

        System.out.println(answer);
    }
}