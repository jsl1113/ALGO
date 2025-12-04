import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] answer = new int[3];
        for (int i = 0; i < 6; i++) {
            answer[0] += arr[i] % t == 0 ? arr[i] / t : arr[i] / t + 1;
        }

        answer[1] = n / p;
        answer[2] = n % p;

        System.out.println(answer[0]);
        System.out.println(answer[1] + " " + answer[2]);
    }
}
