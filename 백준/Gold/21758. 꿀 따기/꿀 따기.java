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
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long answer = 0;

        // 1) 벌 벌 통
        long sum = Arrays.stream(arr).sum();
        long fix = sum - arr[0];  
        long move = fix; 
        for (int i = 1; i < n - 1; i++) {
            move -= arr[i];
            answer = Math.max(answer, (fix - arr[i]) + move);
        }

        // 2) 통 벌 벌
        fix = sum - arr[n - 1]; 
        move = fix;
        for (int i = n - 2; i >= 0; i--) {
            move -= arr[i];
            answer = Math.max(answer, (fix - arr[i]) + move);
        }

        // 3) 벌 통 벌
        fix = 0;  
        move = sum - arr[n - 1];  
        for (int i = 1; i < n - 1; i++) {
            fix += arr[i]; 
            move -= arr[i - 1];
            answer = Math.max(answer, fix + move);
        }

        System.out.println(answer);
    }
}
