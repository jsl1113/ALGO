
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            hs.add(cur);
            if (cur == c) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = c - arr[i];
            if (arr[i] == tmp) continue;
            if (hs.contains(tmp)) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = c - (arr[i] + arr[j]);
                if (tmp == arr[i] || tmp == arr[j]) continue;
                if (hs.contains(tmp)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}