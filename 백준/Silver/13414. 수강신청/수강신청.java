import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> hs = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            if(hs.contains(str)) {
                hs.remove(str);
            }
            hs.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (Object o : hs.toArray()) {
            sb.append(o).append("\n");
            if(--K == 0) break;
        }

        System.out.println(sb);
    }
}