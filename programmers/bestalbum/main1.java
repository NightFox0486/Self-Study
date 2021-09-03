package bestalbum;

public class main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] answer;
        answer = solution.solution(genres, plays);
        for (int ans : answer) {
            System.out.print(ans);
        }
    }
}
