
import java.sql.Array;
import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, String> hm = new HashMap<>();
        String[][] arr = new String[n][2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String[] sa = s.split(" ");
            arr[i][0] = sa[0];
            arr[i][1] = sa[1];
        }

        Arrays.sort(arr,new Comparator<String[]>() { // 0:나이 , 1:이름
            @Override
            public int compare(String[] s1,String[] s2) {
                return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
            }
        });


        for(String[] a : arr){
            System.out.println(a[0] +" "+ a[1]);
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
