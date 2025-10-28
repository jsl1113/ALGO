import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashSet<List> hs = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        dfs(0, 1, list, hs);
    }

    public static void dfs(int cnt, int start, List<Integer> list, HashSet<List> hs) {
        if (cnt == m) {
            if (!hs.contains(list)) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                hs.add(list);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(cnt + 1, i + 1, list, hs);
            list.remove(list.size() - 1);
        }
    }
}