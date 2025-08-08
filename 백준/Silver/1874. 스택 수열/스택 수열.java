import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<String> operations = new ArrayList<>();
        int cnt = 1;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            while (cnt <= num) {
                stack.push(cnt);
                operations.add("+");
                cnt++;
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                operations.add("-");
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            System.out.println("NO");
        } else {
            for (String op : operations) {
                sb.append(op).append("\n");
            }
            System.out.print(sb);
        }
    }
}
