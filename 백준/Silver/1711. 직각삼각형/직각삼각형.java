import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (check(list.get(i), list.get(j), list.get(k))) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(Point p1, Point p2, Point p3) {
        long x = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        long y = (p1.x - p3.x) * (p1.x - p3.x) + (p1.y - p3.y) * (p1.y - p3.y);
        long z = (p2.x - p3.x) * (p2.x - p3.x) + (p2.y - p3.y) * (p2.y - p3.y);

        if (x + y == z || y + z == x || x + z == y) return true;
        else return false;
    }

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
