package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4485 {
    static int[][] map;
    static int[][] temp;
    static int N;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static Queue<Edge> edges = new LinkedList<Edge>();

    static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(temp[i], Integer.MAX_VALUE);
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            temp[0][0] = map[0][0];
            edges.add(new Edge(0, 0));
            while (!edges.isEmpty()) {
                Edge edge = edges.poll();
                int sx;
                int sy;
                for (int i = 0; i < 4; i++) {
                    sx = edge.x + dy[i];
                    sy = edge.y + dx[i];
                    if (sx > N - 1 || sy > N - 1 || sx < 0 || sy < 0)
                        continue;
                    if (map[sx][sy] + temp[edge.x][edge.y] < temp[sx][sy]) {
                        temp[sx][sy] = map[sx][sy] + temp[edge.x][edge.y];
                        edges.add(new Edge(sx, sy));
                    }
                }
            }
            System.out.println("Problem " + t + ": " + temp[N - 1][N - 1]);
            t++;
        }
    }
}
