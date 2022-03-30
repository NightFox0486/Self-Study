package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17144 {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static Point care;

    static class Point {
        int x, y, c;

        Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static void run() {
        while (true) {
            if (T == 0)
                break;
            Queue<Point> queue = new LinkedList<Point>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 4)
                        queue.add(new Point(i, j, map[i][j]));
                }
            }
            while (!queue.isEmpty()) {
                Point current = queue.poll();
                int dust = current.c / 5;
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int sx = current.x + dy[i];
                    int sy = current.y + dx[i];
                    if (sx < 0 || sy < 0 || sx > R - 1 || sy > C - 1 || map[sx][sy] == -1)
                        continue;
                    map[sx][sy] += dust;
                    cnt++;
                }
                map[current.x][current.y] -= dust * cnt;
            }
            // print();
            if (care.y == 0 || care.y == 1) {
                for (int i = care.x - 3; i >= 0; i--) { // 왼쪽 위
                    map[i + 1][0] = map[i][0];
                }
                for (int i = care.x + 2; i < R; i++) { // 왼쪽 아래
                    map[i - 1][0] = map[i][0];
                }
                for (int i = 1; i < C; i++) { // 바깥쪽 왼쪽
                    map[0][i - 1] = map[0][i];
                    map[R - 1][i - 1] = map[R - 1][i];
                }
                for (int i = 1; i <= care.x; i++) { // 오른쪽 위
                    map[i - 1][C - 1] = map[i][C - 1];
                }
                for (int i = R - 2; i >= care.x; i--) { // 오른쪽 아래
                    map[i + 1][C - 1] = map[i][C - 1];
                }
                for (int i = C - 2; i > care.y; i--) { // 가운데 오른쪽
                    map[care.x - 1][i + 1] = map[care.x - 1][i];
                    map[care.x][i + 1] = map[care.x][i];
                }
                map[care.x - 1][care.y + 1] = 0;
                map[care.x][care.y + 1] = 0;
            } else {
                for (int i = care.y - 2; i >= 0; i--) {
                    map[care.x - 1][i + 1] = map[care.x - 1][i];
                    map[care.x][i + 1] = map[care.x][i];
                }
                for (int i = care.x - 3; i >= 0; i--) { // 왼쪽 위
                    map[i + 1][0] = map[i][0];
                }
                for (int i = care.x + 2; i < R; i++) { // 왼쪽 아래
                    map[i - 1][0] = map[i][0];
                }
                for (int i = 1; i < C; i++) { // 바깥쪽 왼쪽
                    map[0][i - 1] = map[0][i];
                    map[R - 1][i - 1] = map[R - 1][i];
                }
                for (int i = 1; i <= care.x; i++) { // 오른쪽 위
                    map[i - 1][C - 1] = map[i][C - 1];
                }
                for (int i = R - 2; i >= care.x; i--) { // 오른쪽 아래
                    map[i + 1][C - 1] = map[i][C - 1];
                }
                for (int i = C - 2; i > care.y; i--) { // 가운데 오른쪽
                    map[care.x - 1][i + 1] = map[care.x - 1][i];
                    map[care.x][i + 1] = map[care.x][i];
                }
                map[care.x - 1][care.y + 1] = 0;
                map[care.x][care.y + 1] = 0;
            }
            // print();
            T--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    if (map[i][j] == -1) {
                        care = new Point(i, j, -1);
                    }
                }
            }
        }
        run();
        int sum = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void print() {
        // System.out.println("===================================");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
