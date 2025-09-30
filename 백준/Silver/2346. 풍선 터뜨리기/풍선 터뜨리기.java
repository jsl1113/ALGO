import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i + 1, Integer.parseInt(strArray[i])});
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (list.size() != 1) {
            int move = list.get(idx)[1];
            int size = list.size() - 1;

            sb.append(list.get(idx)[0]).append(" ");
            list.remove(idx);

            move -= (move > 0 ? 1 : 0);
            idx = (idx + move) % size;
            idx += (idx < 0 ? size : 0);
        }

        sb.append(list.get(0)[0]);
        System.out.println(sb);
    }
}