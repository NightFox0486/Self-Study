package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2636 {

    static int[][] map;
    static boolean[][] check;
    static boolean[][] deletecheck;
    static int R;
    static int C;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static List<Point> list;
    static int prevSize = 0;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void setAir() {
        int cnt = 0;
        while (true) {
            check = new boolean[R][C];
            deletecheck = new boolean[R][C];
            list = new ArrayList<Point>();
            Queue<Point> queue = new LinkedList<Point>();
            queue.add(new Point(0, 0));
            map[0][0] = 2;
            check[0][0] = true;
            while (!queue.isEmpty()) {
                Point current = queue.poll();
                map[current.x][current.y] = 2;
                for (int i = 0; i < 4; i++) {
                    int sx = current.x + dy[i];
                    int sy = current.y + dx[i];
                    if (sx < 0 || sy < 0 || sx > R - 1 || sy > C - 1 || check[sx][sy])
                        continue;
                    if (map[sx][sy] == 1) {
                        if (!deletecheck[sx][sy]) {
                            list.add(new Point(sx, sy));
                            deletecheck[sx][sy] = true;
                        }
                        continue;
                    }
                    queue.add(new Point(sx, sy));
                    check[sx][sy] = true;
                }
            }
            if (list.size() != 0) {
                prevSize = list.size();
                for (int i = 0; i < list.size(); i++) {
                    Point p = list.get(i);
                    map[p.x][p.y] = 0;
                }
            } else {
                System.out.println(cnt);
                System.out.println(prevSize);
                break;
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setAir();
    }
}
