package programmers.morespicier;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pQ.add(scoville[i]);
        }
        while (pQ.peek() < K && pQ.peek() != null) {
            Integer n1 = pQ.poll();
            Integer n2 = pQ.poll();
            if (n1 == null || n2 == null)
                return -1;
            pQ.add(mix(n1, n2));
            answer++;
        }
        // System.out.println(pQ);
        return answer;
    }

    private int mix(int n1, int n2) {
        if (n1 > n2)
            return (n1 * 2) + n2;
        else
            return (n2 * 2) + n1;
    }
}