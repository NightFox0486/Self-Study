package programmers.functiondevelop;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses, speeds;
        progresses = new int[] { 95, 90, 99, 99, 80, 99 };
        speeds = new int[] { 1, 1, 1, 1, 1, 1 };
        solution.solution(progresses, speeds);
    }
}