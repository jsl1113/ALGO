import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, minNum;
    static int[][] ability;
    static List<List<Integer>> testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n + 1][n + 1];
        testCase = new ArrayList<>();
        minNum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < (1 << n - 1); i++) {
            List<Integer> startList = new ArrayList<>();
            List<Integer> linkList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) startList.add(j);
                else linkList.add(j);
            }
            minNum = Math.min(minNum, Math.abs(getScore(startList) - getScore(linkList)));
        }
        System.out.println(minNum);
    }

    public static int getScore(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                sum += ability[list.get(i)][list.get(j)] + ability[list.get(j)][list.get(i)];
            }
        }
        return sum;
    }
}