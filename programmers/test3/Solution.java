package test3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        HashMap<String, Integer> inoutchecker = new HashMap<>();
        HashMap<String, Integer> eachTimetable = new HashMap<>();////////// 차번호와 입출입 시간 저장;
        HashMap<String, Integer> cost = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] parse = records[i].split(" ");
            if (parse[2].equals("IN")) {
                inoutchecker.put(parse[1], timetosec(parse[0]));
            }
            if (parse[2].equals("OUT")) {
                if (eachTimetable.containsKey(parse[1])) {
                    eachTimetable.replace(parse[1],
                            eachTimetable.get(parse[1]) + (timetosec(parse[0]) - inoutchecker.get(parse[1])));
                } else {
                    eachTimetable.put(parse[1], timetosec(parse[0]) - inoutchecker.get(parse[1]));
                }
                inoutchecker.remove(parse[1]);
            }
        }
        Iterator itr = inoutchecker.keySet().iterator();
        while (itr.hasNext()) {
            String getnext = (String) itr.next();
            if (eachTimetable.containsKey(getnext)) {
                eachTimetable.replace(getnext,
                        eachTimetable.get(getnext) + (timetosec("23:59") - inoutchecker.get(getnext)));
            } else {
                eachTimetable.put(getnext, timetosec("23:59") - inoutchecker.get(getnext));
            }

        }
        itr = eachTimetable.keySet().iterator();
        while (itr.hasNext()) {
            String getnext = (String) itr.next();
            cost.put(getnext, getCost(eachTimetable.get(getnext), fees));
        }
        String[] temp = cost.keySet().toArray((new String[cost.size()]));
        answer = new int[cost.size()];
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            answer[i] = cost.get(temp[i]);
        }
        System.out.println(eachTimetable);
        System.out.println(cost);
        return answer;
    }

    private int timetosec(String time) {
        String[] h_m = time.split(":");
        int h = Integer.parseInt(h_m[0]);
        int m = Integer.parseInt(h_m[1]);
        return h * 60 + m;
    }

    private int getCost(int num, int[] fees) {
        int cost = fees[1];
        if (num > fees[0]) {
            double t1 = num - fees[0];
            double t2 = Math.ceil((double) t1 / (double) fees[2]);
            cost += (t2) * fees[3];
        }
        return cost;
    }
}