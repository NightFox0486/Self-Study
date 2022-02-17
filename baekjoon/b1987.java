package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1987 {
    static int R;
    static int C;
    static char[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static boolean[][] check;
    static boolean[] checkAlpabet = new boolean['Z' - 'A' + 1];
    static int max = Integer.MIN_VALUE;

    static void recur(int x, int y, int cnt) {
        if (checkAlpabet[map[x][y] - 'A']) {
            max = Math.max(max, cnt);
            return;
        }
        checkAlpabet[map[x][y] - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int sx = x + dy[i];
            int sy = y + dx[i];
            if (sx < 0 || sy < 0 || sx > R - 1 || sy > C - 1 || check[sx][sy])
                continue;
            recur(sx, sy, cnt + 1);
        }
        checkAlpabet[map[x][y] - 'A'] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        check = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        recur(0, 0, 0);
        System.out.println(max);
    }
}
