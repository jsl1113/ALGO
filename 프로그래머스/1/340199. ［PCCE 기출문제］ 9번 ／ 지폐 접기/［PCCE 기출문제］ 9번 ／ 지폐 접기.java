class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int a = wallet[0], b = wallet[1];
        int c = bill[0], d = bill[1];
        
        while(true){
            if((a >= c && b >= d) || (a >= d && b >= c)){
                break;
            }
            
            if(c > d) c = c/2;
            else d = d/2;
            answer++;
        }
        
        return answer;
    }
}