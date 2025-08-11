import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = i; j < n; j++) {
                sum += A[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }

        long count = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;

            for (int j = i; j < m; j++) {
                sum += B[j];
                count += hm.getOrDefault(T - sum, 0);
            }
        }

        System.out.println(count);
    }
}