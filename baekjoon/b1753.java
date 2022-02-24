package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1753 {
    static int[][] routingtable;
    static int V;
    static int E;
    static int K;
    static int[] distance;
    static boolean[] check;
    static ArrayList<ArrayList<Edge>> vertex = new ArrayList<ArrayList<Edge>>();
    static Queue<Integer> queue = new LinkedList<Integer>();

    static class Edge {
        int v;
        int c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        routingtable = new int[V + 1][V + 1];
        distance = new int[V + 1];
        check = new boolean[V + 1];
        distance[0] = Integer.MAX_VALUE;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routingtable[x][y] = c;
        }
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if (i == j)
                    continue;
                if (routingtable[i][j] == 0)
                    routingtable[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= V; i++) {
            distance[i] = routingtable[K][i];
            if (routingtable[K][i] == 0)
                distance[i] = Integer.MAX_VALUE;
        }
        distance[K] = 0;
        queue.add(K);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int i = 1; i <= V; i++) {
                if (!check[i] && routingtable[start][i] != Integer.MAX_VALUE) {

                    if (distance[i] > distance[start] + routingtable[start][i]) {
                        distance[i] = distance[start] + routingtable[start][i];
                    }
                    check[i] = true;
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }
}
