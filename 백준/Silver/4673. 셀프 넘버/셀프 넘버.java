import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // FastReader fr = new FastReader();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[10001];

        for(int i = 1; i <= 10000; i++){
            int n = d(i);

            if(n < 10001){
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 10000; i++){
            if(!check[i]) sb.append(i).append('\n');
        }
        System.out.print(sb);
    }

    public static int d(int n){ // 생성자가 있는 수
        int ans = n;
        while (n != 0){
            ans += n % 10;
            n /= 10;
        }

        return ans;
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