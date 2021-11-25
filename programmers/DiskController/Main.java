package DiskController;

public class Main {
    public static void main(String[] args) {
        int[][] jobs = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 }, { 15, 2 },
                { 35, 43 }, { 26, 1 } };

        Solution solution = new Solution();
        System.out.println(solution.solution(jobs));
    }
}
