class Solution {
   int answer = 1;
	
	public int solution(int dist_limit, int split_limit) {
		answer = 1;
		dfs(1, 1, 1, 0, dist_limit, split_limit);
        return answer;
    }
    
	void dfs(long cur, long cnt, long split, long leaf, int limit, int splitLimit) {
		if (cnt > limit) return;
		
		answer = (int) Math.max(answer, leaf + cur);
		
		for (int child = 2; child <= 3; child++) {
			if (split * child > splitLimit) continue;
            
			long next = split * child;
			long nextCur = Math.min(cur * child, limit - cnt);
			long nextLeaf = leaf + (cur * child - nextCur);
			
			dfs(nextCur, cnt + nextCur, next, nextLeaf, limit, splitLimit);
		}
    }
}