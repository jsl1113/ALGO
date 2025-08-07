import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        while (n != 0) {
            if (String.valueOf(num).contains("666")) n--;
            num++;
        }

        System.out.println(num - 1);
    }
}
