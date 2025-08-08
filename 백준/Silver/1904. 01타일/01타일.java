import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(1);
        } else if(n == 2){
            System.out.println(2);
        } else {
            int v1 = 1;
            int v2 = 2;
            int sum = 0;

            for(int i = 2; i < n; i++){
                sum = (v2 + v1) % 15746;
                v1 = v2;
                v2 = sum;
            }
            System.out.println(sum);
        }

    }
}
