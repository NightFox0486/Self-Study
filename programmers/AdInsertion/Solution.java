package programmers.AdInsertion;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        long[] all_time = new long[converttimetoInt(play_time)];
        long max = 0;
        long sum = 0;
        for (int i = 0; i < logs.length; i++) {
            String[] part_time = logs[i].split("-");
            int start = converttimetoInt(part_time[0]);
            int end = converttimetoInt(part_time[1]);
            for (int j = start; j < end; j++) {
                all_time[j]++;
            }
        }
        int adv_timeInt = converttimetoInt(adv_time);
        int pro_time = 0;
        for (int i = 0; i < adv_timeInt; i++) {
            sum += all_time[i];
        }
        max = sum;

        for (int i = adv_timeInt; i < all_time.length; i++) {
            sum += all_time[i] - all_time[i - adv_timeInt];
            if (sum > max) {
                max = sum;
                pro_time = i - adv_timeInt + 1;
            }
        }
        // int temp2 = all_time.length-adv_timeInt;
        // for (int i = 0; i < all_time.length; i++) {
        // sum = 0;
        // if (i < temp2) {
        // int temp = i+adv_timeInt;
        // for (int j = i; j < temp; j++) {
        // sum += all_time[j];
        // }
        // if (sum > max) {
        // max = sum;
        // pro_time = i;
        // }
        // }
        // }

        answer = convertInttotime(pro_time);
        return answer;
    }

    private int converttimetoInt(String time) {
        String[] h = time.split(":");
        return Integer.parseInt(h[0]) * 3600 + Integer.parseInt(h[1]) * 60 + Integer.parseInt(h[2]);
    }

    private String convertInttotime(int time) {
        StringBuilder sb = new StringBuilder();
        Integer.toString(time / 3600);
        sb.append(String.format("%02d", time / 3600));
        time -= (time / 3600) * 3600;
        Integer.toString(time / 60);
        sb.append(":" + String.format("%02d", time / 60));
        time -= (time / 60) * 60;
        Integer.toString(time);
        sb.append(":" + String.format("%02d", time));
        return sb.toString();
    }
}