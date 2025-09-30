import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) return;

            int total = calWattHour(a);  // 총 사용량에 따른 총 요금
            int start = 0, end = total / 2;
            while (start <= end) {
                int mid = (start + end) / 2;
                int x = calCost(mid);
                int y = calCost(total - mid);

                int tmp = Math.abs(x - y);
                if (tmp > b) start = mid + 1;
                else if (tmp < b) end = mid - 1;
                else {
                    System.out.println(calCost(mid));
                    break;
                }
            }
        }
    }

    public static int calCost(int n) {  // 사용량에 따라, 내야 할 요금
        if (n <= 100) return 2 * n;
        else if (n <= 10_000) return 200 + 3 * (n - 100);
        else if (n <= 1_000_000) return 29_900 + 5 * (n - 10_000);
        else return 4_979_900 + 7 * (n - 1_000_000);
    }

    public static int calWattHour(int n) { // 전기 요금에 따른 사용량
        if (n <= 200) return n / 2;
        else if (n <= 29_900) return (n - 200) / 3 + 100;
        else if (n <= 4_979_900) return (n - 29_900) / 5 + 10_000;
        else return (n - 4_979_900) / 7 + 1_000_000;
    }
}
