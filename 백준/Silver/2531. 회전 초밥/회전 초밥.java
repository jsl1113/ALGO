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
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int[] eat = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) cnt++;
            eat[arr[i]]++;
        }
        int answer = cnt;

        int start = 0, end = k;
        while (start != n){
            if(eat[arr[start]] == 1) cnt--;
            eat[arr[start]]--;

            if(eat[arr[end]] == 0) cnt++;
            eat[arr[end]]++;

            if(eat[c] == 0) answer = Math.max(answer, cnt + 1);
            else answer = Math.max(answer, cnt);

            start++; end++;

            if(end == n) end = 0;
        }

        System.out.println(answer);
    }
}
