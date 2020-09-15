import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.StringTokenizer;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) throws DateTimeException {
        String answer = "";
        LocalTime pt;
        LocalTime at;
        int total_timetable = 0;
        int[] timestack;
        Timeinteval[] ti = new Timeinteval[logs.length];
        StringTokenizer stk = new StringTokenizer(play_time, ":");
        pt = LocalTime.of(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
                Integer.parseInt(stk.nextToken()));
        stk = new StringTokenizer(adv_time, ":");
        at = LocalTime.of(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
                Integer.parseInt(stk.nextToken()));

        total_timetable = pt.getHour() * 3600 + pt.getMinute() * 60 + pt.getSecond();
        timestack = new int[total_timetable];

        for (int i = 0; i < logs.length; i++) {
            ti[i] = new Timeinteval();
            stk = new StringTokenizer(logs[i], "-");
            String temp1 = stk.nextToken();
            String temp2 = stk.nextToken();
            stk = new StringTokenizer(temp1, ":");
            ti[i].st = LocalTime.of(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
                    Integer.parseInt(stk.nextToken()));
            int t1 = ti[i].st.getHour() * 3600 + ti[i].st.getMinute() * 60 + ti[i].st.getSecond();
            stk = new StringTokenizer(temp2, ":");
            ti[i].et = LocalTime.of(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
                    Integer.parseInt(stk.nextToken()));
            int t2 = ti[i].et.getHour() * 3600 + ti[i].et.getMinute() * 60 + ti[i].et.getSecond();

            for (int j = t1 + 1; j <= t2; j++)
                timestack[j]++;
        }
        int max_start_time = 0;
        int max_end_time = 0;
        int stacktemp = 0;
        int stacktemp1 = 0;
        for (int i = total_timetable - 1; i > 0; i--) {
            if (timestack[i] > stacktemp) {
                max_end_time = i;
                stacktemp = timestack[i];
            }
            if (timestack[i] >= stacktemp1) {
                max_start_time = i - 1;
                stacktemp1 = timestack[i];
            }
        }
        System.out.println(
                LocalTime.of(max_start_time / 3600, max_start_time % 3600 / 60, max_start_time % 60).toString() + " "
                        + LocalTime.of(max_end_time / 3600, max_end_time % 3600 / 60, max_end_time % 60).toString());
        int ad_inteval = at.getHour() * 3600 + at.getMinute() * 60 + at.getSecond();
        if (ad_inteval < max_end_time - max_start_time)
            answer = LocalTime.of(max_start_time / 3600, max_start_time % 3600 / 60, max_start_time % 60).toString();
        else if (ad_inteval > max_end_time - max_start_time) {
            answer = LocalTime.of((max_end_time - ad_inteval) / 3600, (max_end_time - ad_inteval) % 3600 / 60,
                    (max_end_time - ad_inteval) % 60).toString();
        }
        System.out.println(answer);
        return answer;
    }

    class Timeinteval {
        LocalTime st;
        LocalTime et;
    }
}