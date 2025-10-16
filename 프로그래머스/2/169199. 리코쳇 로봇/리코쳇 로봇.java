import java.util.*;

class Solution {
    public static int n, m;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, 1, -1};
    public static int[][] visited;
    
    static class Point {
        int y, x;
        public Point (int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    
    public static int find(String[] boards, int a, int b){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(a,b));
        visited[a][b] = 1;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i = 0 ; i < 4; i++){
                int t = 0;
                while(true){
                    int ny = p.y + (t+1) * dy[i];
                    int y = p.y + t * dy[i];
                    int nx = p.x + (t+1) * dx[i];
                    int x = p.x + t * dx[i]; 

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || boards[ny].charAt(nx) == 'D') {
                        if (visited[y][x] == 0) {
                            visited[y][x] = visited[p.y][p.x] + 1;
                            queue.add(new Point(y,x));
                            if (boards[y].charAt(x) == 'G') return visited[y][x] - 1;
                        }
                        break;
                    }

                    t++;
                }

            }
        }
        
        return -1;
    }
    
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        int result = 0;
        
        visited = new int[n][m];
        for (int i = 0 ; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (board[i].charAt(j) == 'R'){
                    result = find(board, i, j);
                }
            }
        }
        
        return result;
    }
}