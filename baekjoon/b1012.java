package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1012 {
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[][] map = new int[N][M];
            boolean[][] check = new boolean[N][M];
            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j] || map[i][j] == 0)
                        continue;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    check[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point current = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int sx = current.x + dy[k];
                            int sy = current.y + dx[k];
                            if (sx < 0 || sy < 0 || sx > N - 1 || sy > M - 1 || map[sx][sy] == 0 || check[sx][sy])
                                continue;
                            queue.add(new Point(sx, sy));
                            check[sx][sy] = true;
                        }
                    }
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
