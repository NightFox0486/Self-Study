package sportwear;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            flag[i] = 1;
        }
        for (int j = 0; j < lost.length; j++) {
            flag[lost[j] - 1] -= 1;
        }
        for (int j = 0; j < reserve.length; j++) {
            flag[reserve[j] - 1] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                if (i == 0) {
                    if (flag[i + 1] == 2) {
                        flag[i] += 1;
                        flag[i + 1] -= 1;
                    }
                } else if (i == n - 1) {
                    if (flag[i - 1] == 2) {
                        flag[i - 1] -= 1;
                        flag[i] += 1;
                    }
                } else {
                    if (flag[i - 1] == 2) {
                        flag[i - 1] -= 1;
                        flag[i] += 1;
                    } else if (flag[i + 1] == 2) {
                        flag[i + 1] -= 1;
                        flag[i] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (flag[i] > 0)
                answer++;
        }
        // System.out.println(Arrays.toString(flag));
        return answer;
    }
}