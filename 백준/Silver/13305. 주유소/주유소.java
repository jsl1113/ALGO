import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] cost = new long[n];

        // dist input 
        String[] s1 = br.readLine().split(" ");
        for(int i = 0; i < n-1; i++){
            dist[i] = Long.parseLong(s1[i]);
        }
        
        // cost input 
        String[] s2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            cost[i] = Long.parseLong(s2[i]);
        }

        long sum = 0;
        long minCost = cost[0];

        for(int i = 0; i < n-1; i++){
            if(cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * dist[i]);
        }
        System.out.println(sum);
    }
}