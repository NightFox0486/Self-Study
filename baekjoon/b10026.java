package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10026 {
    static int N;
    static int cnt1 = 0;
    static int cnt2 = 0;
    static char[][] map;
    static boolean[][] check;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static void checker(int x, int y) {
        check[x][y] = true;
        int sx, sy;
        for (int i = 0; i < 4; i++) {
            sx = x + dy[i];
            sy = y + dx[i];
            if (sx > N - 1 || sy > N - 1 || sx < 0 || sy < 0 || check[sx][sy])
                continue;
            if (map[x][y] == map[sx][sy])
                checker(sx, sy);
        }
    }

    static void checker2(int x, int y) {
        check[x][y] = true;
        int sx, sy;
        for (int i = 0; i < 4; i++) {
            sx = x + dy[i];
            sy = y + dx[i];
            if (sx > N - 1 || sy > N - 1 || sx < 0 || sy < 0 || check[sx][sy])
                continue;
            if (map[x][y] == map[sx][sy])
                checker(sx, sy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        map = new char[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j])
                    continue;
                cnt++;
                checker(i, j);
            }
        }
        cnt1 = cnt;
        cnt = 0;
        for (int i = 0; i < N; i++)
            Arrays.fill(check[i], false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j])
                    continue;
                cnt++;
                checker2(i, j);
            }
        }
        cnt2 = cnt;
        System.out.println(cnt1 + " " + cnt2);
    }
}
