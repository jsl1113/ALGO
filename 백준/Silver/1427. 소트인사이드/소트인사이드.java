import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        ArrayList<Integer> arr = new ArrayList<>();
        int n = fr.nextInt();
        while(n != 0){
          int tmp = n % 10;
          arr.add(tmp);
          n /= 10;
        }
        Collections.sort(arr);
        
        for(int i = arr.size()-1; i >= 0; i--) {
        	System.out.print(arr.get(i));
        }
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