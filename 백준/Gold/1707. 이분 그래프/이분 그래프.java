
import java.io.*;
import java.util.*;

public class Main {
    public static int[] group;
    public static ArrayList<ArrayList<Integer>> g;
    public static int v, e, a, b;
    public static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            check = true;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            g = new ArrayList<>();
            for(int i = 0; i < v; i++){
                g.add(new ArrayList<>());
            }

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;

                g.get(a).add(b);
                g.get(b).add(a);
            }
            group = new int[v];
            for(int i = 0; i < v; i++){
                if(group[i] == 0){
                    if(bfs(i) == false) break;
                }
            }
            if(check) sb.append("YES" + "\n");
            else sb.append("NO" + "\n");
        }
        System.out.println(sb.toString());
    }

    static boolean bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        group[n] = 1;
        while(!q.isEmpty()){
            int node = q.poll();

            for(Integer i: g.get(node)){
                if(group[node] == group[i]) {
                    // 인접한 곳이 같은 팀인지 체크
                    check = false;
                    return false;
                }
                if(group[i] == 0){
                    // 방문하지 않았으면 자신과 반대되는 팀을 넣음
                    group[i] = group[node] + 1;
                    q.add(i);
                }
            }
        }
        return true;
    }
}
