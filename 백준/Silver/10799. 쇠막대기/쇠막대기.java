import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0, stick = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stick++;
            } else {
                stick--;

                if (input.charAt(i - 1) == '(') {
                    answer += stick;
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
