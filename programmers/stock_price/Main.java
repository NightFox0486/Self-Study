package programmers.stock_price;

public class Main {
    public static void main(String[] args) {
        int[] prices = { 5, 1, 8, 5, 2, 3, 2, 4 };
        int[] answer;
        Solution solution = new Solution();
        answer = solution.solution(prices);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
