import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, op;
    static int[] answer = { Integer.MIN_VALUE, Integer.MAX_VALUE };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(op));
        dfs(1, arr[0]);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            answer[0] = Math.max(answer[0], sum);
            answer[1] = Math.min(answer[1], sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                dfs(idx + 1, cal(sum, arr[idx], i));
                op[i]++;
            }
        }
    }

    public static int cal(int a, int b, int op) {
        int result = 0;
        switch (op) {
            case 0 -> result = a + b;
            case 1 -> result = a - b;
            case 2 -> result = a * b;
            case 3 -> result = a / b;
        }

        return result;
    }
}
