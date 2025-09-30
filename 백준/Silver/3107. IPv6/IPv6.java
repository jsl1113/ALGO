import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.contains("::")) {
            s = s.replace("::", ":check:");
        }
        String[] strArray = s.split(":");

        ArrayList<String> input = new ArrayList<>();
        for(int i = 0; i < strArray.length; i++) {
            input.add(strArray[i]);
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            String next = input.get(i);

            if(next.isEmpty()) continue;

            int cnt = 4 - next.length();
            while(cnt-- > 0) {
                next = "0" + next;
            }

            list.add(next);
        }

        String[] ip = new String[8];
        int zero = 8 - list.size() + 1,  idx = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("check")) {
                while(zero-- > 0) {
                    ip[idx++] = "0000";
                }
            } else {
                ip[idx++] = list.get(i);
            }
        }

        System.out.println(String.join(":", ip));
    }
}
