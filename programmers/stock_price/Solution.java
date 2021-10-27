package stock_price;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i]++;
                    if (prices[i] > prices[j])
                        break;
                }
            }
        }
        return answer;
    }
}