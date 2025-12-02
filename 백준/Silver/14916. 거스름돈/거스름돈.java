import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = n / 5;
        int num = n % 5;
        
        if (num != 0) {
            while (num % 2 != 0) {
                num += 5;
                cnt--;
                if (cnt < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        cnt += num / 2;
        System.out.println(cnt);
    }
}

