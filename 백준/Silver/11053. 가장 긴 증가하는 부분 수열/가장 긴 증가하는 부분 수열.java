
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            d[i] = 1;

            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }

        int max = -1;
        for(int i = 0; i < n; i++){
            max = d[i] > max ? d[i] : max;
        }
        System.out.println(max);
    }
}
