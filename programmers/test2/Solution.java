package programmers.test2;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String knum = ntok(n, k);
        for (int i = 0; i < knum.length(); i++) {

        }
        return answer;
    }

    private String ntok(int n, int k) {
        int[] value;
        int length = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < n; i *= k)
            length++;
        value = new int[length];
        for (int i = 0; 0 < n; i++) {
            value[i] = (n % k);
            n /= k;
        }
        for (int i = length - 1; 0 < i; i--)
            sb.append(Integer.toString(value[i]));
        return sb.toString();
    }

}
