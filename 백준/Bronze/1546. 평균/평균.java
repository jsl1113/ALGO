

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        // Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = fr.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int grade = fr.nextInt();
            arr1.add(grade);
        }

        double max = Collections.max(arr1);

        for(int i = 0; i < n; i++){
            double tmp = arr1.get(i);
            tmp = (double) tmp / max * 100;
            arr2.add(i, tmp);
        }

        double sum = 0;
        for(int i = 0; i < n; i++)
            sum += arr2.get(i);

        System.out.println((double) sum / n);
        // br.close();
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