import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder answerBuilder = new StringBuilder();
        Stack<Character> operStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if(token == '(') {
                operStack.push(token);
            }
            else if(token == '*' || token == '/') {
                while(!operStack.empty() && (operStack.peek() == '*' || operStack.peek() == '/'))
                    answerBuilder.append(operStack.pop());
                operStack.push(token);
            }
            else if(token == '+' || token == '-'){
                while(!operStack.empty() && operStack.peek() != '(')
                    answerBuilder.append(operStack.pop());
                operStack.push(token);
            }
            else if(token == ')'){
                char top = operStack.pop();
                while(!operStack.empty() && top != '('){
                    answerBuilder.append(top);
                    top = operStack.pop();
                }
            }
            else answerBuilder.append(token);
        }

        while (!operStack.empty()) {
            answerBuilder.append(operStack.pop());
        }

        System.out.println(answerBuilder);
    }
}