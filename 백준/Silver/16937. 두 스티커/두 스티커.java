import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int h, w, n, max = 0;
    static boolean[] visited;
    static List<Sticker> list;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int start, int cnt) {
        if (cnt == 2) {
            int[] arr = new int[2];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) arr[idx++] = i;
            }
            solution(arr);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static void solution(int[] arr) {
        boolean flag = false;
        Sticker s1 = list.get(arr[0]);
        Sticker s2 = list.get(arr[1]);

        if (check(s1.h, s1.w, s2.h, s2.w) || check(s1.w, s1.h, s2.h, s2.w) ||
                check(s1.h, s1.w, s2.w, s2.h) || check(s1.w, s1.h, s2.w, s2.h)) {
            flag = true;
        }

        if (flag) max = Math.max(max, s1.h * s1.w + s2.h * s2.w);
    }

    static boolean check(int h1, int w1, int h2, int w2) {
        if ((h1 + h2 <= h && Math.max(w1, w2) <= w) ||
                (Math.max(h1, h2) <= h && w1 + w2 <= w)) return true;
        else return false;
    }

    static class Sticker {
        int h, w;

        Sticker(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Sticker(r, c));
        }
        visited = new boolean[n];
    }
}
