package DiskController;

public class Main {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 10 }, { 2, 10 }, { 9, 10 }, { 15, 2 } };
        Solution solution = new Solution();
        System.out.println(solution.solution(jobs));
    }
}
