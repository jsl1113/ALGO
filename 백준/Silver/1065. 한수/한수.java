import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // FastReader fr = new FastReader();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(han(Integer.parseInt(br.readLine())));
    }

    public static int han(int n){ // 생성자가 있는 수
        int cnt = 0;
        if(n < 100) {
            return n;
        }
        else {
            cnt = 99;
            if(n == 1000){
                n = 999;
            }

            for(int i = 100; i <= n; i++){
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;

                if((a-b) == (b-c)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}