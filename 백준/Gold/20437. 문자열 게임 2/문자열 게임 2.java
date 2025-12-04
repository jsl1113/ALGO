import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Map<Character, List<Integer>> map = new HashMap<>();
            List<Character> characters = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), new ArrayList<>());
            }

            for (int i = 0; i < s.length(); i++) {
                List<Integer> list = map.get(s.charAt(i));
                list.add(i);
                map.put(s.charAt(i), list);
            }

            for(Character c : map.keySet()){
                if(map.get(c).size() >= k) characters.add(c);
            }

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (Character c : characters) {
                List<Integer> idxList = map.get(c);
                for (int i = 0; i < idxList.size() - k + 1; i++) {
                    min = Math.min(min, idxList.get(i + k - 1) - idxList.get(i) + 1);
                    max = Math.max(max, idxList.get(i + k - 1) - idxList.get(i) + 1);
                }
            }

            if(characters.size() == 0) sb.append(-1).append("\n");
            else {
                sb.append(min).append(" ").append(max).append("\n");
            }

            T--;
        }
        System.out.println(sb);
    }
}