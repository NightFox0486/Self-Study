package programmers.carpet;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int key = brown + yellow;
        for (int i = key; i >= Math.sqrt(key); i--) {
            int j = -1;
            if (key % i == 0) {
                j = key / i;
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}