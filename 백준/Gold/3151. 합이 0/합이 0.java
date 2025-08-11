import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counter = new int[40001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += counter[20000-nums[i]];
            for (int j = 0; j < i; j++) {
                counter[20000+nums[i]+nums[j]]++;
            }
        }
        System.out.println(ans);
    }

}