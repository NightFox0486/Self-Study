package DiskController;

public class Main {
    public static void main(String[] args) {
        int[][] jobs = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 2 }, { 15, 34 },
                { 35, 43 }, { 26, 1 } };

        Solution2 solution = new Solution2();
        System.out.println(solution.solution(jobs));
    }
}
