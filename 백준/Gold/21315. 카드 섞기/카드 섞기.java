import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        card = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            card[i] = i+1;
        }

        for (int k1 = 1; Math.pow(2, k1) < n; k1++) {
            for (int k2 = 1; Math.pow(2, k2) < n; k2++) {
                int[] cards = card.clone();
                shuffle(k1, cards);
                shuffle(k2, cards);

                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (cards[i] != arr[i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }

    }

    static void shuffle(int k, int[] cards) {
        int size = n;
        int cnt;

        for (int i = 1; i <= k + 1; i++) {
            cnt = (int) Math.pow(2, k - i + 1);
            swap(size, cnt, cards);
            size = cnt;
        }
    }

    static void swap(int size, int cnt, int[] cards) {
        List<Integer> list = new ArrayList<>();

        for (int i = size - cnt; i < size; i++) {
            list.add(cards[i]);
            cards[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (cards[i] != 0) {
                list.add(cards[i]);
            }
            cards[i] = list.get(i);
        }
    }
}
