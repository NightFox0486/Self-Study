package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {
    static int N;
    static int M;
    static int V;
    static int[][] map;
    static boolean[] check;
    static int[] store;

    public static void dfs(int n) {
        System.out.print(n + " ");
        check[n] = true;
        for (int i = 1; i <= N; i++) {
            if (!check[i] && map[n][i] == 1)
                dfs(i);
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (check[temp])
                continue;
            check[temp] = true;
            System.out.print(temp + " ");
            for (int i = 1; i <= N; i++) {
                if (!check[i] && map[temp][i] == 1)
                    queue.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        store = new int[N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;

        }
        // dfs;
        dfs(V);
        // bfs;
        System.out.println();
        Arrays.fill(check, false);
        bfs(V);
    }
}