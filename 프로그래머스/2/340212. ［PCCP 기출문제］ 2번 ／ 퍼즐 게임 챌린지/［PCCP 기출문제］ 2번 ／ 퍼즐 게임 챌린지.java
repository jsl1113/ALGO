import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1, end = Arrays.stream(diffs).max().getAsInt();
        while(start <= end){
            int mid = (start + end) / 2;
            long time = cal(diffs, times, mid);
            
            if(time > limit) start = mid + 1;
            else end = mid - 1;
        }
        
        return start;
    }
    
    public long cal(int[] diffs, int[] times, long mid){
        long answer = 0;
        
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= mid) answer += times[i];
            else answer += (long)(times[i] + times[i-1]) * (long)(diffs[i] - mid) + times[i];
        }
        
        return answer;
    }
}