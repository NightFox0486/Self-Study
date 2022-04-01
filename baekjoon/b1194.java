package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1194 {
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static boolean[] key = new boolean[6];
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] check;
    static int sx, sy, ex, ey;
    static int cost = -1;

    static class Point {
        int x, y, c, key;

        Point(int x, int y, int c, int key) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.key = key;
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx, sy, 0, 0));
        check[sx][sy][0] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (map[current.x][current.y] == '1') {
                cost = current.c;
                return;
            }
            if (map[current.x][current.y] == 'a' || map[current.x][current.y] == 'b' || map[current.x][current.y] == 'c'
                    || map[current.x][current.y] == 'd' || map[current.x][current.y] == 'e'
                    || map[current.x][current.y] == 'f')
                current.key = current.key | (1 << map[current.x][current.y] - 'a');
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dy[i];
                int ny = current.y + dx[i];
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || map[nx][ny] == '#' || check[nx][ny][current.key])
                    continue;
                if (map[nx][ny] == 'A' || map[nx][ny] == 'B' || map[nx][ny] == 'C'
                        || map[nx][ny] == 'D' || map[nx][ny] == 'E'
                        || map[nx][ny] == 'F') {
                    if ((current.key & (1 << map[nx][ny] - 'A')) == 0)
                        continue;
                }
                queue.add(new Point(nx, ny, current.c + 1, current.key));

                check[nx][ny][current.key] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M][1 << 6];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }
        bfs();
        System.out.println(cost);
    }
}