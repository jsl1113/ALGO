import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> lengthStack = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                int cnt = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    cnt += lengthStack.pop();
                }

                stack.pop();
                int tmp = stack.pop() - '0';
                stack.push('0');

                lengthStack.pop();
                lengthStack.push(tmp * cnt);
            } else {
                stack.push(c);
                lengthStack.push(1);
            }
        }

        int answer = 0;
        while (!lengthStack.isEmpty()) {
            answer += lengthStack.pop();
        }

        System.out.println(answer);
    }
}
