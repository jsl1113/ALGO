import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int mask = 1; mask < (int) Math.pow(2, n); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0){
                    list.add(arr[i]);
                }
            }

            int tmp = 0;
            for(int l : list) tmp += l;
            if(tmp == sum) cnt ++;
        }

        System.out.println(cnt);
    }
}