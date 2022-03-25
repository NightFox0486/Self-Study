package programmers.sportwear;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] lost = { 2, 4 };
        int[] reserve = { 1, 3, 5 };
        System.out.println(solution.solution(n, lost, reserve));
    }
}
