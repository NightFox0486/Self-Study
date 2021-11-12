package DiskController;

import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Heap<Integer[]> hp = new Heap<Integer[]>(jobs.length + 1);
        // Arrays.sort(jobs);
        for (int i = 0; i < jobs[jobs.length - 1][0]; i++) {
            if (i == 0 || !hp.isEmpty()) {
                for (int j = 0; j == jobs[j][0]; j++) {
                    hp.push(Arrays.stream(jobs[j]).boxed().toArray(Integer[]::new));
                }
            }
        }
        return answer;
    }
}