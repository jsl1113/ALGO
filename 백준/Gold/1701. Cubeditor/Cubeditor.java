import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int left = 0, right = s.length() - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(s, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(String s, int len) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (set.contains(sub)) return true;
            set.add(sub);
        }
        return false;
    }
}