import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] state;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr1 = new int[n];
        state = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = s1.charAt(i) - '0';
            state[i] = s2.charAt(i) - '0';
        }

        int[] arr2 = Arrays.copyOf(arr1, n);
        arr2[0] = swap(arr2[0]);
        arr2[1] = swap(arr2[1]);

        int[] answer = new int[2];
        answer[0] = push(n, arr1);
        answer[1] = push(n, arr2);
        if(answer[1] != -1) answer[1]++; // 누르고 시작한 케이스기 때문에 +1

        if(answer[0] == -1) System.out.println(answer[1]);
        else if(answer[1] == -1) System.out.println(answer[0]);
        else System.out.println(Math.min(answer[0], answer[1]));
    }

    public static int push(int n, int[] arr) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != state[i]) {
                cnt++;
                arr[i] = swap(arr[i]);
                arr[i + 1] = swap(arr[i + 1]);
                if(i != n-2) arr[i + 2] = swap(arr[i + 2]);
            }
        }
        return arr[n - 1] != state[n - 1] ? -1 : cnt;
    }

    private static int swap(int n) {
        return n == 0 ? 1 : 0;
    }
}
