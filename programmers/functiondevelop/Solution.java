package programmers.functiondevelop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int cnt = 0;
        int progress;
        LinkedList<Integer> progresseslist = new LinkedList<Integer>();
        LinkedList<Integer> speedslist = new LinkedList<Integer>();
        ArrayList<Integer> answerlist = new ArrayList<Integer>();
        for (int i = 0; i < progresses.length; i++) {
            progresseslist.add(i, progresses[i]);
            speedslist.add(i, speeds[i]);
        }
        Iterator<Integer> iter;
        while (!progresseslist.isEmpty()) {
            for (int i = 0; i < progresseslist.size(); i++) {
                progresseslist.set(i, progresseslist.get(i) + speedslist.get(i));
            }
            iter = progresseslist.iterator();
            while (iter.hasNext()) {
                progress = iter.next();
                if (progress >= 100) {
                    cnt++;
                    progresseslist.poll();
                    speedslist.poll();
                    iter = progresseslist.iterator();
                    if (progresseslist.isEmpty()) {
                        if (cnt != 0) {
                            answerlist.add(cnt);
                        }
                        cnt = 0;
                    }
                } else {
                    if (cnt != 0) {
                        answerlist.add(cnt);
                    }
                    cnt = 0;
                    break;
                }
            }
        }
        answer = answerlist.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}