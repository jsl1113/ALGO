import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n, max;
    static ArrayList<Integer> numList;
    static ArrayList<Character> opList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        String str = br.readLine();

        max = Integer.MIN_VALUE;
        char[] input = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) numList.add(input[i] - '0');
            else opList.add(input[i]);
        }

        dfs(0, numList.get(0));
        System.out.println(max);
    }

    public static void dfs(int idx, int sum) {
        if (idx >= opList.size()) {  
            max = Math.max(max, sum);
            return;
        }

        // 괄호 안 넣기
        dfs(idx + 1, cal(sum, numList.get(idx + 1), opList.get(idx)));

        // 괄호 넣기
        if (idx + 1 < opList.size()) {
            int tmp = cal(numList.get(idx+1), numList.get(idx+2), opList.get(idx+1));
            dfs(idx + 2, cal(sum, tmp, opList.get(idx)));
        }
    }

    public static int cal(int a, int b, char oper) {
        int result = 0;
        switch (oper) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
        }
        return result;
    }
}