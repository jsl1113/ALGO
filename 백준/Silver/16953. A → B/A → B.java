import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long answer = Integer.MAX_VALUE;
    static boolean flag = false;
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 1);
        if(flag) System.out.println(answer);
        else System.out.println(-1);
//        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(long num, int cnt) {
        if(num > b) return;
        if (num == b) {
            flag = true;
            answer = cnt;
//            answer = Math.min(answer, cnt);
            return;
        }

        dfs(2 * num, cnt + 1);
        dfs(num * 10 + 1, cnt + 1);
    }
}
