import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stick[] arr = new Stick[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Stick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (a, b) -> a.L - b.L);

        int answer = 0, max = 0;
        Stick stick = arr[0];
        for (int i = 1; i < n; i++) {
            Stick current = arr[i];

            if (stick.H <= current.H) {
                answer += (current.L - stick.L) * stick.H;
                stick = current;
                max = i;
            }
        }

        stick = arr[n - 1];
        for (int i = 1; i < n - max; i++) {
            Stick current = arr[n - 1 - i];

            if (stick.H <= current.H) {
                answer += (stick.L -  current.L) * stick.H;
                stick = current;
            }
        }

        System.out.println(answer + arr[max].H);
    }

    static class Stick {
        int L, H;

        Stick(int L, int H) {
            this.L = L;
            this.H = H;
        }

        public String toString() {
            return L + " " + H;
        }
    }
}
