package programmers.test5;

import java.util.ArrayList;

class Solution {
    public int solution(int[] info, int[][] edges) throws InterruptedException {
        int answer = 0;
        boolean[] flag = new boolean[info.length];
        ArrayList<Solution.Node> list = new ArrayList<Solution.Node>();
        for (int i = 0; i < info.length; i++) {
            Node node = new Node(info[i], i);
            list.add(node);
        }
        for (int i = 0; i < edges.length; i++) {
            if (list.get(edges[i][0]).left == null) {
                list.get(edges[i][0]).left = list.get(edges[i][1]);
                list.get(edges[i][1]).parent = list.get(edges[i][0]);
            } else
                list.get(edges[i][0]).right = list.get(edges[i][1]);
            list.get(edges[i][1]).parent = list.get(edges[i][0]);
        }
        search(list.get(0), 0, 0, flag, answer);

        return answer;
    }

    private class Node {
        int index;
        int sheep;
        int wolf;
        Node parent = null;
        Node left = null;
        Node right = null;

        Node(int info, int index) {
            this.sheep = 0;
            this.wolf = 0;
            if (info == 0)
                this.sheep++;
            else
                this.wolf++;

            this.index = index;
        }
    }

    public void search(Solution.Node Node, int wolf, int sheep, boolean[] flag, int answer)
            throws InterruptedException {
        int cnt = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                cnt++;
            }
        }
        if (cnt < flag.length) {
            wolf += Node.wolf;
            Node.wolf = 0;
            sheep += Node.sheep;
            Node.sheep = 0;
            flag[Node.index] = true;

            System.out.println(Node.index + " wolf: " + wolf + " sheep: " + sheep);
            // Thread.sleep(1000);

            if (Node.left != null)
                if (sheep > Node.left.wolf + wolf)
                    search(Node.left, wolf, sheep, flag, answer);

            if (Node.right != null)
                if (sheep > Node.right.wolf + wolf)
                    search(Node.right, wolf, sheep, flag, answer);

            if (Node.parent != null)
                search(Node.parent, wolf, sheep, flag, answer);
        }
    }
}