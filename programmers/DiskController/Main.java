package DiskController;

public class Main {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 10 }, { 2, 12 }, { 9, 19 }, { 15, 17 } };
        Solution solution = new Solution();
        System.out.println(solution.solution(jobs));
    }
}
