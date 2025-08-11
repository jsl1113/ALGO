
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //FastReader fr = new FastReader();
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        boolean check;
        int cnt = 0;

        for(int i = 0; i < 10; i++){
            int n = Integer.parseInt(br.readLine()) % 42;
            arr.add(n);
        }

        for (int i = 0; i< 10; i++){
            check = false;
            for(int j = i+1; j < arr.size(); j++){
                if(arr.get(i) == arr.get(j)){
                    check = true;
                    break;
                }
            }

            if (check == false) {
                cnt++;
            }
        }
        System.out.println(cnt);
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