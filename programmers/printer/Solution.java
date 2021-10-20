package printer;

import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        Priority_index[] pi = new Priority_index[priorities.length];
        ArrayList<Priority_index> al = new ArrayList<Priority_index>();
        ArrayList<Priority_index> answer_list = new ArrayList<Priority_index>();
        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i] > max) {
                max = priorities[i];
            }
            pi[i] = new Priority_index();
            pi[i].index = i;
            pi[i].priority = priorities[i];
            al.add(i, pi[i]);
        }
        int i = 0;
        int cnt = al.size() + 1;
        while (!al.isEmpty()) {
            if (i == al.size()) {
                i = 0;
            }
            if (cnt == 0) {
                max--;
                cnt = al.size();
            }
            if (al.get(i).priority == max) {
                answer_list.add(al.get(i));
                al.remove(i);
                cnt = al.size() + 1;
                i--;
            }
            i++;
            cnt--;
        }
        for (i = 0; i < answer_list.size(); i++) {
            if (answer_list.get(i).index == location) {
                answer = i + 1;
            }
        }
        return answer;
    }

    class Priority_index {
        int index;
        int priority;
    }
}

// class Solution {
// public int solution(int[] priorities, int location) {
// int answer = 0;
// int temp = priorities[location];
// boolean checker = false;
// int j = -1;
// int cnt = 1;
// for (int i = 0; i < priorities.length; i++) {
// if (j != -1) {
// if (i == location)
// continue;
// if (priorities[i] >= priorities[location])
// cnt++;

// if (location > i && priorities[i] == priorities[location])
// cnt--;
// }
// if (priorities[i] > temp && checker == false) {
// cnt++;
// j = i;
// checker = true;
// }
// }
// answer = cnt;
// return answer;
// }
// }

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

// class Solution {
// public int solution(int[] priorities, int location) {
// int answer = 0;
// int priority = 0;
// List<Priorindex> list = new LinkedList<Priorindex>();
// List<Priorindex> sortedlist = new ArrayList<Priorindex>();
// for (int i = 0; i < priorities.length; i++) {
// Priorindex element = new Priorindex(i, priorities[i]);
// list.add(element);
// }
// do {
// for (int i = 0; i < list.size(); i++) {
// if (list.get(i).value > priority) {
// priority = priorities[i];
// }
// }
// while (list.get(0).value != priority) {
// if (list.size() == 1) {
// list.remove(0);
// break;
// }
// list.add(list.remove(0));
// }
// for (int i = 0; i < list.size(); i++) {
// if (priority == list.get(i).value) {
// sortedlist.add(list.remove(0));
// }
// }
// priority = 0;
// } while (!list.isEmpty());
// for (int i = 0; i < sortedlist.size(); i++) {
// if (sortedlist.get(i).index == location) {
// answer = i + 1;
// break;
// }
// }
// return answer;
// }

// class Priorindex {
// int index;
// int value;

// Priorindex(int i, int v) {
// this.index = i;
// this.value = v;
// }
// }
// }