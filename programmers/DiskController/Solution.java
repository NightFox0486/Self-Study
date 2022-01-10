package DiskController;

import java.util.Arrays;
import java.util.Comparator;

//commit test
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int total_time = 0;
        Heap<int[]> hp = new Heap<int[]>(jobs.length + 1);
        Comparator comp = new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }

        };
        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        });
        int j = 0;
        for (int i = 0; !hp.isEmpty() || j < jobs.length; i++) {
            while (j < jobs.length && total_time >= jobs[j][0] || j == 0) {
                hp.push(jobs[j], comp);
                j++;
            }
            if (hp.isEmpty() && j < jobs.length) {
                hp.push(jobs[j], comp);
                j++;
            }
            if (!hp.isEmpty()) {
                int[] sample = hp.pop(comp);
                if (i == 0 && sample[0] != 0)
                    total_time += sample[0];
                if (sample[0] > total_time)
                    answer += sample[1];
                else
                    answer += total_time - sample[0] + sample[1];
                // System.out.println(answer);
                total_time += sample[1];
            }
        }

        answer /= jobs.length;
        return answer;
    }

    class Process {
        int arrival_time;
        int processing_time;

        Process(int arrival_time, int processing_time) {
            this.arrival_time = arrival_time;
            this.processing_time = processing_time;
        }

        public int getArrival() {
            return this.arrival_time;
        }

        public int getProcessing() {
            return this.processing_time;
        }
    }
}