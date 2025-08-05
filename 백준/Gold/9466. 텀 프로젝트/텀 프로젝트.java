import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 반복해서 각 학생으로 시작, 싸이클이 되면 종료한다.
public class Main {
    static int n, answer;
    static int[] arr;
    static boolean[] cycle, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n];
            visited = new boolean[n];
            cycle = new boolean[n];
            answer = n;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
                if(arr[i] == i) {
                    cycle[i] = true;
                    answer--;
                }
            }

            // 반복해서 시작 학생 기준 사이클을 찾는다.
            for(int i = 0; i < n; i++) {
                if(!cycle[i]) {
                    dfs(i);
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int student) {
        if(cycle[student]) return;

        if(visited[student]) {
            answer--;
            cycle[student] = true;
        }

        visited[student] = true;
        dfs(arr[student]);
        visited[student] = false;

        cycle[student] = true; // student 싸이클 여부 확인했으므로 true 처리
    }
}
