import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int L = s.length();

        int a = 0;
        for (int i = 0; i < L; i++) {
            if(s.charAt(i) == 'a') a++;
        }

        int answer = 1001;
        for (int i = 0; i < L; i++) {
            int b = 0;
            for (int j = i; j < i + a; j++) {
                if (s.charAt(j % L) == 'b') {
                    b++;
                }
            }
            answer = Math.min(answer, b);
        }

        System.out.println(answer);
    }
}
