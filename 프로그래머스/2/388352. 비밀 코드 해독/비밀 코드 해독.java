import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, n, q, ans);
        return answer;
    }
    
    private void dfs(int index, int n, int[][] q, int[] ans) {
        if(index > n && set.size() < 5) return;
        
        if(set.size() == 5) {
            if(check(q, ans)) {
                answer++;
            }
            return;
        }
        
        for(int i = index; i <= n; i++) {
            set.add(i);
            dfs(i+1, n, q, ans);
            set.remove(i);
        }
    }
    
     private boolean check(int[][] q, int[] ans) {
        for (int y = 0; y < q.length; y++) {
            int cnt = 0;
            
            for (int x = 0; x < 5; x++) {
                if (set.contains(q[y][x])) {
                    cnt++;
                }
            }
            
            if (cnt != ans[y]) return false;
        }
         
        return true;
    }
}