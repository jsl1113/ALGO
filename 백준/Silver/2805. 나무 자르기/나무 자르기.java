import java.util.*;
import java.io.*;




public class Main {

    public static void main(String[] args) throws IOException {
      FastReader fr = new FastReader();
      int n = fr.nextInt();
      int m = fr.nextInt();
      int[] arr = new int[n];
      int maxLength = (int)-1e9;

      for(int i = 0; i < n; i++){
        arr[i] = fr.nextInt();
        maxLength = Math.max(maxLength, arr[i]);
      }
      
      int start = 0;
      int end = maxLength;
      int result = 0;

      while(start <= end){
        int mid = (start + end) / 2; // 중간점(높이)
        long total = 0;

        for(int i = 0; i < n; i++) {
          if(mid < arr[i]) total += arr[i] - mid;
        }

        if(total < m) end = mid - 1;
        else {
          start = mid + 1;
          result = mid;
        }
      }
      System.out.println(result);
    
    }


    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
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