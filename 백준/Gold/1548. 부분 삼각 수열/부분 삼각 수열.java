import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] strArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[] arr) {
        Arrays.sort(arr);
        int maxLength = Math.min(n, 2);

        for (int i = 0; i < n - 1; i++) { // 앞에서부터 탐색
            for (int j = n - 1; j >= 0; j--) { // 뒤에서부터 탐색
                if(i + 1 == j) break;  // 같은 수를 검사하지 않게

                if (arr[i] + arr[i + 1] > arr[j]) {
                    maxLength = Math.max(maxLength, j - i + 1);
                    break;
                }
            }
        }

        return maxLength;
    }
}