import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FastReader fr = new FastReader(); 
 
        ArrayList<Integer> arr = new ArrayList<>();

        // 9개의 데이터를 하나씩 입력받기 
        for(int i = 0; i < 9; i++){
          int x = fr.nextInt();
          arr.add(x);
        }

        int maxValue = (int) - 1e9; // 가장 큰 값
        int maxIdx = 0; // 가장 큰 값의 위치

        for (int i = 0; i < 9; i++){
          if(maxValue < arr.get(i)){
            maxValue = arr.get(i);
            maxIdx = i;
          }
        }
        System.out.println(maxValue);
        System.out.println(maxIdx + 1);
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