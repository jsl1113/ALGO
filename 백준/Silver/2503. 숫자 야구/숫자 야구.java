import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 야구
public class Main {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(reader.readLine());
        int[][] ballInfo = new int[tries][3];
        for (int i = 0; i < tries; i++) {
            StringTokenizer countTokens = new StringTokenizer(reader.readLine());
            ballInfo[i] = new int[]{
                    Integer.parseInt(countTokens.nextToken()),
                    Integer.parseInt(countTokens.nextToken()),
                    Integer.parseInt(countTokens.nextToken())
            };
        }
        int answer = 0;
        // for 반복문으로 자연수 세개를 나열
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == i) continue;
                for (int k = 1; k < 10; k++) {
                    if (k == i || k == j) continue;
                    // 답변 후보 배열
                    int[] answerCandi = new int[]{i, j, k};
                    boolean isAnswer = true;
                    // 질문들을 순회하며 답변 후보와 비교
                    for (int t = 0; t < tries; t++) {
                        int select = ballInfo[t][0];
                        int[] result = getCount(select, answerCandi);
                        // 실제 볼카운트와 동일한지 살펴본다.
                        if(result[0] != ballInfo[t][1] || result[1] != ballInfo[t][2]) {
                            // 얘는 답이 될 수 없음
                            isAnswer = false;
                            break;
                        }
                    }
                    if(isAnswer) answer++;
                }
            }
        }

        return answer;
    }

    // 두 숫자의 볼카운트를 반환하는 메소드
    public int[] getCount(int select, int[] answer) {
        int strikes = 0;
        int balls = 0;

        int[] selectNums = new int[]{select / 100, (select / 10) % 10, select % 10};

        for (int i = 0; i < 3; i++) {
            // 1. 스트라이크 판정
            if(selectNums[i] == answer[i]) strikes++;
            // 2. 스트라이크 아닐 때 볼 판정
            else{
                for (int j = 0; j < 3; j++) {
                    if(selectNums[j] == answer[i]) balls++;
                }
            }
        }
        return new int[]{strikes, balls};
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Main().solution());
    }
}