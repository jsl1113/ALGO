
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] arr = new int[20][2];
    static int[] d = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 고객수 도시갯수
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 비용
            arr[i][1] = Integer.parseInt(st.nextToken());   // 고객수
        }
        System.out.println(f(c, n));
    }
    
    static int f(int c, int n){
        int min = (100 * 1000);
        int cost;
        if(c <= 0)
            return 0;

        else if(d[c] > 0)
            return d[c];

        else {
            for(int i = 0; i < n; i++){
                cost = f(c - arr[i][1], n) + arr[i][0];
                min = cost < min ? cost : min;
            }
            d[c] = min;
            return min;
        }
    }
}
