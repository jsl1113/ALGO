class Solution {
    boolean solution(String s) {
        int cnt = 0;

        for (Character c : s.toCharArray()) {
            if(c == '(') cnt++;
            else if(cnt > 0) cnt--;
            else return false;
        }

        return cnt == 0;
    }
}