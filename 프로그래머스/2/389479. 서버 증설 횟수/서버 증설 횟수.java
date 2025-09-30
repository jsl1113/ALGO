class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[players.length];
        for(int i = 0; i < players.length; i++) {
            if(players[i] == 0) continue;
            if(players[i] / m <= servers[i]) continue;
            
            for(int j = 1; j < k && (i+j) < servers.length; j++) {
                servers[i + j] += players[i] / m - servers[i];
            }
            
            answer += players[i] / m - servers[i];
        }
        
        return answer;
    }
}