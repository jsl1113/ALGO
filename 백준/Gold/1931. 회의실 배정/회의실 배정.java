
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //서로 겹치지 않는 활동에 대해 종료시간이 빠르면
        // 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것


        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int x = 0;
        for(int i = 0; i < n; i++){
            if(x <= time[i][0]) {
                x = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

