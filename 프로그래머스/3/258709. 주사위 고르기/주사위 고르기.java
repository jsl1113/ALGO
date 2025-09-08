import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    int[][] dice;
    int[] combi;
    ArrayList<int[]> list;
    ArrayList<Integer> score;
    
    public int[] solution(int[][] dice) {
        int diceCnt = dice.length;
        int maxWinCnt = 0;
        int[] answer = {};

        this.dice = dice;
        this.list = new ArrayList<>();
        this.score = new ArrayList<>();

        combi = new int[diceCnt / 2];
        calculateCombination(0, 0, diceCnt / 2);

        for (int i = 0; i < list.size() / 2; i++) {
            int[] myDice = list.get(i);
            int[] oppDice = list.get(list.size() - i - 1);

            HashMap<Integer, Integer> myScoreCnt = calculateScoreCnt(myDice, 0, myDice.length);
            HashMap<Integer, Integer> oppScoreCnt = calculateScoreCnt(oppDice, 0, oppDice.length);

            int winCnt = 0, loseCnt = 0;

            for (int m : myScoreCnt.keySet()) {
                for (int o : oppScoreCnt.keySet()) {
                    int cases = myScoreCnt.get(m) * oppScoreCnt.get(o);
                    if (m > o) winCnt += cases;
                    else if (m < o) loseCnt += cases;
                }
            }

            if (winCnt > maxWinCnt) {
                maxWinCnt = winCnt;
                answer = myDice;
            }
            if (loseCnt > maxWinCnt) {
                maxWinCnt = loseCnt;
                answer = oppDice;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        return answer;
    }
    
    void calculateCombination(int start, int depth, int maxDepth) {
        if (depth == maxDepth) {
            list.add(combi.clone());
            return;
        }
        for (int i = start; i < dice.length; i++) {
            combi[depth] = i;
            calculateCombination(i + 1, depth + 1, maxDepth);
        }
    }

    HashMap<Integer, Integer> calculateScoreCnt(int[] combi, int depth, int maxDepth) {
        if (depth == maxDepth) {
            HashMap<Integer, Integer> scoreCnt = new HashMap<>();
            for (int s : score) {
                scoreCnt.put(s, scoreCnt.getOrDefault(s, 0) + 1);
            }
            score.clear();
            return scoreCnt;
        }

        int idx = combi[depth];
        if (score.isEmpty()) {
            for (int v : dice[idx]) score.add(v);
        } else {
            int size = score.size();
            for (int i = 0; i < size; i++) {
                int base = score.remove(0);
                for (int v : dice[idx]) {
                    score.add(base + v);
                }
            }
        }
        return calculateScoreCnt(combi, depth + 1, maxDepth);
    }
}