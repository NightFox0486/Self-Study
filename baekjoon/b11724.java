package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class b11724 {
    static int N;
    static int M;
    static boolean[] check;
    static int cnt = 0;
    static List<List> list;

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (check[current])
                continue;
            check[current] = true;
            for (int i = 0; i < list.get(current).size(); i++) {
                queue.add((int) list.get(current).get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        list = new ArrayList<>();
        check = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
