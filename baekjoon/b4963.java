package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4963 {
    static int w;
    static int h;
    static int[][] input;
    static boolean[][] visited;
    static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int sx = current.x + dy[i];
                int sy = current.y + dx[i];
                if (sx < 0 || sy < 0 || sx > h - 1 || sy > w - 1 || visited[sx][sy] || input[sx][sy] == 0)
                    continue;
                queue.add(new Point(sx, sy));
                visited[sx][sy] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if (w == 0 && h == 0)
                break;
            input = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && input[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
