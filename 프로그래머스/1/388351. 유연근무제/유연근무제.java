class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<timelogs.length; i++){
            int[] timelog = timelogs[i];
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            
            if(minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            
            int tmp = 0;
            for(int j=0; j<timelog.length; j++){
                if((j+startday) % 7 == 6 || (j+startday) % 7 == 0) continue;
                
                int h = timelog[j] / 100;
                int m = timelog[j] % 100;
                
                if(hour < h) break;
                else if(hour == h && minute < m) break;
                else tmp++;
            }
            
            if(tmp >= 5) answer++;
        }
        
        return answer;
    }
}