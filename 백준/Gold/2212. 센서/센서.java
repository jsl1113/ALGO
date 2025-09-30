import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    static int solution() {
        if(n <= k) return 0;
        
        int[] diff = new int[n - 1];
        for (int i = 1; i < n; i++) diff[i - 1] = arr[i] - arr[i - 1];
        Arrays.sort(diff);

        for (int i = n - 2; i >= n - k; i--) diff[i] = 0;
        return Arrays.stream(diff).sum();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }
}
