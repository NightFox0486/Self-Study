package test1;

public class main1 {
    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.solution(id_list, report, k).toString());
    }
}
