import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while(start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= n; i++){
                cnt += Math.min(mid / i, n);
            }

            if(k <= cnt){
                end = mid;
            } 
            else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
