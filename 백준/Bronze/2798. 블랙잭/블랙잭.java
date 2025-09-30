import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int cardCount = Integer.parseInt(infoToken.nextToken());
        int target = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardTokens = new StringTokenizer(reader.readLine());
        int[] cards = new int[cardCount];
        for (int i = 0; i < cardCount; i++)
            cards[i] = Integer.parseInt(cardTokens.nextToken());

        int max = 0;
        // 3장의 카드를 뽑는다
        for (int i = 0; i < cardCount - 2; i++) { // 첫번째 카드 -> n장의 카드가 있다면 첫번째는 n-2까지
            for (int j = i + 1; j < cardCount - 1; j++) { // 두번째 카드 -> n-1까지
                for (int k = j + 1; k < cardCount; k++) { // 세번째 카드 -> n까지
                    // TODO
                    int sum = cards[i] + cards[j] + cards[k];
                    // 이번 카드 3장의 합이 여태까지 구한 것 중 가장 크다.
                    if (sum <= target && sum > max) max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}