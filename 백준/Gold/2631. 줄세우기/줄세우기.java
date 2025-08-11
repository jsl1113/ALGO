import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];

            if(list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int start = 0, end = list.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;

                    if(list.get(mid) < num) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                list.set(end, num); // 위치 지정해서 값 넣기
            }
        }

        System.out.println(n - list.size());
    }
}
