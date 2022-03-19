package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;
    int d;
    int c;

    Position(int x, int y, int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}

public class b1726 {

    static int M;
    static int N;
    static int[] dy = { 0, 0, 0, 1, -1 };
    static int[] dx = { 0, 1, -1, 0, 0 };
    static int[][] map;
    static boolean[][][] check;
    static int sx;
    static int sy;
    static int sd;
    static int ex;
    static int ey;
    static int ed;
    static int min = Integer.MAX_VALUE;

    static void bfs(Position p) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(p);
        check[p.x][p.y][p.d] = true;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.x == ex && current.y == ey) {
                if (ed != current.d) {
                    if (dy[ed] == dy[current.d] || dx[ed] == dx[current.d])
                        current.c += 2;
                    else
                        current.c += 1;
                }
                System.out.println("test");
                min = Math.min(current.c, min);
            }
            for (int i = 1; i <= 4; i++) {
                int cost = 0;
                int sx = current.x + dy[i];
                int sy = current.y + dx[i];
                if (sx < 0 || sy < 0 || sx > M - 1 || sy > N - 1 || map[sx][sy] == 1 || check[sx][sy][i])
                    continue;
                if (i != current.d) {
                    if (dy[i] == dy[current.d] || dx[i] == dx[current.d])
                        cost += 2;
                    else
                        cost += 1;
                    cost += 1;
                }
                check[sx][sy][i] = true;
                queue.add(new Position(sx, sy, i, current.c + cost));
                // check[current.x][current.y] = false;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        check = new boolean[M][N][5];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        sd = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;
        ed = Integer.parseInt(st.nextToken());
        bfs(new Position(sx, sy, sd, 0));
        System.out.println(min);
    }
}
