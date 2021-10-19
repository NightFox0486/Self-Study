package functiondevelop;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses, speeds, answer;
        progresses = new int[] { 95, 90, 99, 99, 80, 99 };
        speeds = new int[] { 1, 1, 1, 1, 1, 1 };
        answer = solution.solution(progresses, speeds);
    }
}