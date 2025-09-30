import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 10000;
        int mode = 10000;

        for (int i = 0; i < n; i++){
            int v = Integer.parseInt(br.readLine());
            sum += v;
            arr[v + 4000]++;

            if (max < v) max = v;
            if (min > v) min = v;
        }

        int cnt = 0; // 중앙값 빈도 누적 수
        int mode_max = 0; // 최빈값의 최댓값
        boolean flag = false; // 이전의 동일한 최빈값이 1번만 등장했을 경우 true
        for(int i = min + 4000; i <= max + 4000; i++){
            if(arr[i] > 0){
                if(cnt < (n + 1)/2) {
                    cnt += arr[i];
                    median = i - 4000;
                }
                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                else if(mode_max == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        System.out.println((int) Math.round((double) sum / n));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
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
