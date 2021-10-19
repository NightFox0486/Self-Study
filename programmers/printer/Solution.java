package printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int priority = 0;
        List<Priorindex> list = new LinkedList<Priorindex>();
        List<Priorindex> sortedlist = new ArrayList<Priorindex>();
        for (int i = 0; i < priorities.length; i++) {
            Priorindex element = new Priorindex(i, priorities[i]);
            list.add(element);
        }
        do {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).value > priority) {
                    priority = priorities[i];
                }
            }
            while (list.get(0).value != priority) {
                if (list.size() == 1) {
                    list.remove(0);
                    break;
                }
                list.add(list.remove(0));
            }
            for (int i = 0; i < list.size(); i++) {
                if (priority == list.get(i).value) {
                    sortedlist.add(list.remove(0));
                }
            }
            priority = 0;
        } while (!list.isEmpty());
        for (int i = 0; i < sortedlist.size(); i++) {
            if (sortedlist.get(i).index == location) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    class Priorindex {
        int index;
        int value;

        Priorindex(int i, int v) {
            this.index = i;
            this.value = v;
        }
    }
}