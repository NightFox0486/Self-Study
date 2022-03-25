package programmers.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 0;
        }
        ArrayList<String> anw = new ArrayList<String>();
        HashMap<String, Integer> hmid = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            hmid.put(id_list[i], 0);
        }
        // int[] reported = new int[id_list.length];
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] re = report[i].split(" ");
            String from = re[0];
            String to = re[1];
            if (!hm.containsKey(from)) {
                hm.put(from, new HashSet<String>());
            }
            hm.get(from).add(to);
        }
        Iterator<String> itr = hm.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Iterator<String> itr2 = hm.get(key).iterator();
            while (itr2.hasNext()) {
                String temp = (String) itr2.next();
                hmid.replace(temp, hmid.get(temp) + 1);
            }
        }

        // System.out.println(hmid);
        // for (int i = 0; i < id_list.length; i++) {
        // answer[i] = hmid.get(id_list[i]);
        // }
        itr = hmid.keySet().iterator();
        while (itr.hasNext()) {
            String temp = (String) itr.next();
            if (hmid.get(temp) >= k) {
                anw.add(temp);
            }
        }
        System.out.println(anw);
        for (int i = 0; i < id_list.length; i++) {
            itr = anw.iterator();
            while (itr.hasNext()) {
                if (hm.get(id_list[i]) == null)
                    break;
                if (hm.get(id_list[i]).contains(itr.next()))
                    answer[i]++;
            }
        }

        return answer;
    }
}