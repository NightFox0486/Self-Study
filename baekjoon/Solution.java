
class Solution {
    public String solution(int day, int width, int blocks) {
        String answer = "";
        int remain = 0;
        int no_cnt = 0;
        int cnt = 0;
        int sell_total = 0;
        for (int i = 0; i < n; i++) {
            if (no_cnt > 2)
                break;
            if ((p[i] + remain) >= c[i]) {
                remain = (p[i] + remain) - c[i];
                if (no_cnt == 0) {
                    sell_total += c[i] * 100;
                    no_cnt = 0;
                } else if (no_cnt == 1) {
                    sell_total += c[i] * 50;
                    no_cnt = 0;
                } else if (no_cnt == 2) {
                    sell_total += c[i] * 25;
                    no_cnt = 0;
                }
            } else {
                no_cnt++;
                remain += p[i];
            }
            cnt++;
        }
        answer = Double.toString((Math.round((double) sell_total / cnt) * 1000) / 1000.0);
        return answer;
    }
}