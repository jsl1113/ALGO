import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] tmp = arr.clone();
        Arrays.sort(arr);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i], cnt++);
        }
        for(int i = 0; i < n; i++){
            sb.append(hm.get(tmp[i])).append(" ");
        }
        System.out.println(sb.toString());
    }

}
