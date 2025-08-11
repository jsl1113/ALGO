import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BitSet[] bs = new BitSet[n + 1];
        for (int i = 1; i <= n; i++) {
            bs[i] = new BitSet(1001);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bs[a].set(b);
        }

//        System.out.println(Arrays.toString(bs));

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                BitSet set = new BitSet(1024);

                set.or(bs[i]);
                set.and(bs[j]);
                answer += ((long) set.cardinality() * (set.cardinality() - 1)) / 2;
            }
        }

        System.out.println(answer);
    }
}
