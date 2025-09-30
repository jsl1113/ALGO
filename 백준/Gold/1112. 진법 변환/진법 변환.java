import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Long> result = new ArrayList<>();
        boolean flag = false;

        if (x == 0) { 
            System.out.println(0);
            return;
        }

        if (x < 0 && b > 0) { 
            x = -x;
            flag = true;
        }

        while (x != 0) {
            long r = x % b;
            long q = x / b;

            if (r < 0) { 
                r += Math.abs(b);
                q += 1;
            }

            result.add(r);
            x = q;
        }

        Collections.reverse(result);

        if (flag) {
            System.out.print("-");
        }

        for (Long num : result) {
            System.out.print(num);
        }
    }
}
