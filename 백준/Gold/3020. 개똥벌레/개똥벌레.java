import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] up = new int[n / 2];
        int[] down = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = n;
        int cnt = 0;

        for (int i = 1; i < h + 1; i++) {
            int num = binarySearch(0, n / 2, i, down) +
                    binarySearch(0, n / 2, h - i + 1, up);

            if(min == num) {
                cnt++;
                continue;
            }

            if (min > num) {
                min = num;
                cnt = 1;
            }
        }

        System.out.println(min + " " + cnt);
    }

    static int binarySearch(int start, int end, int h, int[] arr) {
        while (start < end) {
            int mid = (start + end) / 2;

            if(arr[mid] >= h) end = mid;
            else start = mid + 1;
        }

        return arr.length - end;
    }
}
