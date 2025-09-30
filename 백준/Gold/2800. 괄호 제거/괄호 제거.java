import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String input;
    static ArrayList<int[]> arrayList;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        arrayList = new ArrayList<>();
        answer = new TreeSet<>();

        int start = input.indexOf('(');
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        for (int i = start + 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '(' && c != ')') continue;
            if (c == '(') {
                stack.push(i);
            } else {
                arrayList.add(new int[]{stack.pop(), i});
            }
        }

        for (int i = 1; i <= (1 << arrayList.size()); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < arrayList.size(); j++) {
                if((i & (1 << j)) != 0) {
                    list.add(arrayList.get(j)[0]);
                    list.add(arrayList.get(j)[1]);
                }
            }
            if(!list.isEmpty()) answer.add(removeString(list));
        }

        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static String removeString(List<Integer> idxList) {
        StringBuilder result = new StringBuilder(input);
        idxList.sort((a, b) -> Integer.compare(b, a));
        for (int idx : idxList) {
            if (idx >= 0 && idx < result.length()) {
                result.deleteCharAt(idx);
            }
        }
        return result.toString();
    }
}
