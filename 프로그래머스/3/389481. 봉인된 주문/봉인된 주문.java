import java.util.*;

class Solution {
    private long toRank(String s) {
        long rank = 0;
        
        for (int i = 1; i < s.length(); i++){
            rank += (long) Math.pow(26, i);
        }
        
        for (int i = 0; i < s.length(); i++) {
            rank += (s.charAt(i) - 'a') * (long) Math.pow(26, s.length() - 1 - i);
        }
        
        return rank + 1;
    }

    private String toStr(long n) {
        long total = 0;
        int len = 0;

        while (total < n) {
            total += (long) Math.pow(26, ++len);
        }

        long idx = n - (total - (long) Math.pow(26, len)) - 1;
        char[] chars = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            chars[i] = (char)('a' + idx % 26);
            idx /= 26;
        }

        return new String(chars);
    }
    
    public String solution(long n, String[] bans) {
        long[] ranks = Arrays.stream(bans).mapToLong(this::toRank).sorted().toArray();
        for (long r : ranks) {
            if (r <= n) n++; 
            else break;
        }
        
        return toStr(n);
    }
}