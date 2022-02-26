package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int min = Integer.MAX_VALUE;

    static class Point {
        int x, y, c;

        Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int bfs(int x, int y, int cnt) {
        Queue<Point> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        queue.add(new Point(x, y, cnt));
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            max = Math.max(max, temp.c);
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dy[i];
                int ny = temp.y + dx[i];
                if (nx > M - 1 || ny > N - 1 || nx < 0 || ny < 0 || map[nx][ny] == -1)
                    continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[temp.x][temp.y] + 1;
                    queue.offer(new Point(nx, ny, temp.c + 1));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Point> list = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        int[][] tempArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = map[i][j];
                if (map[i][j] == 1) {
                    list.add(new Point(i, j, 0));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while (!list.isEmpty()) {
            Point temp = list.remove(list.size() - 1);
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    map[i][j] = tempArr[i][j];
            min = Math.min(min, bfs(temp.x, temp.y, 0));
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(min);
    }
}
