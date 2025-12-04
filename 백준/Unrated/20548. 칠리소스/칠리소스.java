import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        long answer = 0;
        long digit = 1;

        while (n > 0) {
            answer += (n % 7) * digit;
            n /= 7;
            digit *= 3;
        }

        System.out.println(answer);
    }
}
