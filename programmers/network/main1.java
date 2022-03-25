package programmers.network;

public class main1 {
    public static void main(String[] args) {
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        int n = computers.length;
        Solution solution = new Solution();
        System.out.println(solution.solution(n, computers));
    }
}
