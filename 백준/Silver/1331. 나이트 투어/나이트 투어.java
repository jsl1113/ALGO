import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[37];
        for (int i = 0; i < 36; i++) input[i] = br.readLine();
        input[36] = input[0];
        
        boolean[][] visited = new boolean[6][6];
        for (int i = 0; i < 36; i++) {
            String s = input[i];
            String next = input[i + 1];

            char cx = s.charAt(0), cy = s.charAt(1);
            char nx = next.charAt(0), ny = next.charAt(1);
            visited[cy - '0' - 1][cx - 'A'] = true;

            if (!check(Math.abs(cx - nx), Math.abs(cy - ny))) {
                System.out.println("Invalid");
                return;
            }

            if (visited[ny - '0' - 1][nx - 'A']) {
                if(i != 35){
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        System.out.println("Valid");
    }

    static boolean check(int x, int y) {
        int[][] point = {{1, 2}, {2, 1}};
        for (int i = 0; i < 2; i++) {
            if (point[i][0] == x && point[i][1] == y) {
                return true;
            }
        }
        return false;
    }
}