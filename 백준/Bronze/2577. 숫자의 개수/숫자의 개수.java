import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader(); 
 
        int a = fr.nextInt();
        int b = fr.nextInt();
        int c = fr.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int result = a * b * c;

        String tmp = Integer.toString(result);
        int[] cnt = new int[10]; // 값이 모두 0으로 초기화

        for(int i = 0; i < tmp.length(); i++){
          cnt[Integer.parseInt(tmp.charAt(i) + "")] += 1;
        }

        for(int i = 0; i < 10; i++) 
          System.out.println(cnt[i]);
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