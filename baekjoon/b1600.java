package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1600 {
    static int K;
    static int W;
    static int H;
    static int[][] map;
    static boolean[][][] check;
    static int[] dy = { -1, 1, 0, 0, };
    static int[] dx = { 0, 0, -1, 1, };
    static int[] dy2 = { -2, -2, 2, 2, -1, -1, 1, 1 };
    static int[] dx2 = { -1, 1, -1, 1, -2, 2, -2, 2 };
    static boolean checkarrive = false;

    static int cnt = 0;

    static class Point {
        int x, y, c, j;

        Point(int x, int y, int c, int j) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.j = j;
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(0, 0, 0, 0));
        check[0][0][0] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == H - 1 && current.y == W - 1) {
                cnt = current.c;
                checkarrive = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int sx = current.x + dy[i];
                int sy = current.y + dx[i];
                if (sx < 0 || sy < 0 || sx > H - 1 || sy > W - 1 || map[sx][sy] == 1 || check[sx][sy][current.j])
                    continue;
                queue.add(new Point(sx, sy, current.c + 1, current.j));
                check[sx][sy][current.j] = true;
            }
            if (current.j < K) {
                for (int i = 0; i < 8; i++) {
                    int sx = current.x + dy2[i];
                    int sy = current.y + dx2[i];
                    if (sx < 0 || sy < 0 || sx > H - 1 || sy > W - 1 || map[sx][sy] == 1
                            || check[sx][sy][current.j + 1])
                        continue;
                    queue.add(new Point(sx, sy, current.c + 1, current.j + 1));
                    check[sx][sy][current.j + 1] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        check = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if (!checkarrive)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }
}
