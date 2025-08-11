import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() % 2 == 1) continue;
            
            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for (int j = 1; j < str.length(); j++) {
                if (stack.size() > 0 && stack.peek() == str.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
