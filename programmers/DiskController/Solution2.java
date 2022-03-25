package programmers.DiskController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int solution(int[][] jobs) {
        int totalTime = 0;
        Comparator comparator = new Comparator<int[]>() { // jobs 를 도착시간, task 시간기준 비교

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        };
        Arrays.sort(jobs, comparator); // jobs 를 도착시간, task 시간기준 정렬
        PriorityQueue<int[]> hq = new PriorityQueue<int[]>(comparator);

        int i = 0;
        totalTime = jobs[i][0]; // 처음 도착한 task의 시작시간
        do {
            while (i < jobs.length && jobs[i][0] <= totalTime) { // 현재 진행된 시간 까지 도착한 task가 있으면 추가
                hq.add(jobs[i++]);
                continue;
            }

            while (!hq.isEmpty() && hq.peek()[0] <= totalTime) {
                totalTime += hq.peek()[1];
                hq.poll();
            }
        } while (i <= jobs.length);

        return 0;
    }
}
// have to task
// 1. hq ordering 수정 총 task 시간 줄이게
// 2. task 안끝났는데 중간에 task가 비는 경우 해결