import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] king, stone;
    static int n;
    static String[] moves;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            char[] k = king.clone();
            char[] s = stone.clone();

            move(moves[i], k);
            if(!check(k)){
                if (Arrays.equals(k, s)) {
                    move(moves[i], s);

                    if (!check(s)) {
                        king = k;
                        stone = s;
                    }
                } else {
                    king = k;
                }
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }

    static boolean check(char[] c) {
        return (c[0] < 'A' || c[0] > 'H' || c[1] < '1' || c[1] > '8');
    }

    static void move(String str, char[] c) {
        switch (str) {
            case "R" -> c[0]++;
            case "L" -> c[0]--;
            case "B" -> c[1]--;
            case "T" -> c[1]++;
            case "RT" -> { c[0]++; c[1]++; }
            case "LT" -> { c[0]--; c[1]++; }
            case "RB" -> { c[0]++; c[1]--; }
            case "LB" -> { c[0]--; c[1]--; }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        n = Integer.parseInt(st.nextToken());
        moves = new String[n];
        for (int i = 0; i < n; i++) {
            moves[i] = br.readLine();
        }
    }
}