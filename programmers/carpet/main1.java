package carpet;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 8;
        int yellow = 1;
        int[] answer;
        answer = solution.solution(brown, yellow);
        System.out.println(answer[0] + "," + answer[1]);
    }
}
