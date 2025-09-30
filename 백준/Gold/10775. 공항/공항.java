import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int num = find(Integer.parseInt(br.readLine()));
            if (num == 0) break;

            answer++;
            union(num, num - 1);
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}

