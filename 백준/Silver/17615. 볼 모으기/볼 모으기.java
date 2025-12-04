import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = Math.min(movebBack(str, str.charAt(n - 1)), moveFront(str, str.charAt(0)));
        System.out.println(answer);
    }

    static int movebBack(String str, char c) {
        int red = 0,  blue = 0;
        boolean flag = false;
        for (int i = str.length() - 2; i >= 0; i--) {
            if(c == str.charAt(i) && !flag) continue;
            flag = true;
            if(str.charAt(i) == 'R') red++;
            else blue++;
        }
        return Math.min(red, blue);
    }

    static int moveFront(String str, char c) {
        int red = 0, blue = 0;
        boolean flag = false;
        for (int i = 1; i < str.length(); i++) {
            if(c == str.charAt(i) && !flag) continue;
            flag = true;
            if(str.charAt(i) == 'R') red++;
            else blue++;
        }
        return Math.min(red, blue);
    }
}
