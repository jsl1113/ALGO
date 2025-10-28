import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, distance;
    static int[][] city;
    static List<Point> chicken, house;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(tmp[j]);
                if(city[i][j] == 2) chicken.add(new Point(i, j));
                if(city[i][j] == 1) house.add(new Point(i, j));
            }
        }

        distance = Integer.MAX_VALUE;
        isVisit = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(distance);
    }

    public static void dfs(int start, int cnt) {
        if(cnt == m){
            distance = Math.min(distance, getChickenStreet());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            isVisit[i] = true;
            dfs(i + 1, cnt + 1);
            isVisit[i] = false;
        }
    }

    public static int getChickenStreet() { // 이 도시의 치킨 거리 구하기
        int dis = 0;
        for(Point h : house){
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if(isVisit[i]) minNum = Math.min(Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y), minNum);
            }
            dis += minNum;
        }
        return dis;
    }
}
