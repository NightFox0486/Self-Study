package DiskController;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Heap<int[]> hp = new Heap<int[]>(jobs.length + 1);
        Comparator comp = new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }

        };
        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        for (int i = 0; i <= jobs[jobs.length - 1][0]; i++) {
            hp.push(jobs[i], comp);
        }

        System.out.println(hp.pop(comp)[0]);
        // for (int i = 0; i < jobs[jobs.length - 1][0]; i++) {
        // if (i == 0 || !hp.isEmpty()) {
        // for (int j = 0; j == jobs[j][0]; j++) {
        // hp.push(jobs[i], comp);
        // }
        // }
        // }
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