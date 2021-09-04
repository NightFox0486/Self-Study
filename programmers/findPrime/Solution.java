package findPrime;

import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] numchar = numbers.toCharArray();
        int[] numint = new int[numbers.length()];
        HashSet<Integer> numset = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            numint[i] = numchar[i] + 48;
        }

        /// 모든 경우의수 탐색후 hash에 넣어서 중복 제거

        return answer;
    }

    boolean isPrime(int num) {
        return false;
    }
}
