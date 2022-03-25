package programmers.printer;

public class main1 {
    public static void main(String[] args) {
        int[] priorities = { 1, 1, 9, 1, 1, 1 };
        int location = 0;
        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }
}