import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = func(a, b, c);
        System.out.println(answer);
    }

    static long func(long a, long b, long c) {
        if(b == 1) return a % c;

        long n = func(a, b / 2, c);

        if(b% 2 != 0) return n * n % c * a % c;
        else return n * n % c;
    }
}
