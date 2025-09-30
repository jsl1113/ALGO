import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
    			
        int n = fr.nextInt();
        int[] cnt = new int[10001];
        
        for(int i = 0; i < n; i++) {
        	int x = fr.nextInt();
        	cnt[x]++;
        }

    	StringWriter sw = new StringWriter();
    	BufferedWriter bw = new BufferedWriter(sw);
    	

        for(int i = 0; i <= 10000; i++) {
        	for(int j = 0; j < cnt[i]; j++) {
            	bw.write(i + "\n");
        	}
        }
        
        bw.flush();
        System.out.println(sw.getBuffer());
        
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