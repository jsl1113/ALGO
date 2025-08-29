

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            if(arr[i] > list.get(list.size() - 1)) list.add(arr[i]);
            else {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= arr[i]){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, arr[i]);
            }
        }
        System.out.println(list.size() - 1);
    }
}
