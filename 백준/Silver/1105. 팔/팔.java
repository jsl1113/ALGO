import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        int answer = 0;
        if(l.length() != r.length()){
            System.out.println(answer);
            return;
        }

        int idx = 0;
        while (idx < l.length() && l.charAt(idx) == r.charAt(idx)) {
            if (l.charAt(idx) == '8') {
                answer++;
            }
            idx++;
        }

        System.out.println(answer);
    }
}