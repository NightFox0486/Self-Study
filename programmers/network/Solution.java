package programmers.network;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[j]) {
                    continue;
                } else {
                    if (i == j) {
                        answer++;
                        continue;
                    } else {
                        if (computers[i][j] == 1) {
                            flag[j] = true;
                            sub(j, n, computers, flag);
                        }
                    }
                }
            }
        }

        return answer;
    }

    private void sub(int j, int n, int[][] computers, boolean[] flag) {
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            } else {
                if (i == j) {
                    continue;
                } else {
                    if (computers[j][i] == 1) {
                        flag[i] = true;
                        sub(i, n, computers, flag);
                    }
                }
            }
        }
    }

    // class Node{
    // static private Node head = null;
    // static private int headcnt = 0;
    // Node nextNode = null;
    // int value = 0;

    // Node(int value){
    // this.value = value;
    // }

    // private void addNode(int value){
    // Node node = new Node(value);
    // if(head==null){
    // head=node;

    // }
    // }
    // }
}