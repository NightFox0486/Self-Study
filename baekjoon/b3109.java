package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3109 {
    static int R;
    static int C;
    static boolean[][] map;
    static boolean checker = false;
    static int[][] check;
    static int cnt = 0;
    static int[] dy = { -1, 0, 1 };
    static int[] dx = { 1, 1, 1 };

    static void recur(int x, int y) {
        if (y == C - 1) {
            cnt++;
            checker = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int sx = x + dy[i];
            int sy = y + dx[i];
            if (sx < 0 || sx > R - 1 || sy > C - 1 || map[sx][sy] || checker) /////////////////////// 위치가 사용되고 있거나 건물에
                                                                              /////////////////////// 막혀있으면 가지 않음
                continue;
            check[sx][sy] = 1;
            map[sx][sy] = true;
            recur(sx, sy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        check = new int[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                if (temp.charAt(j) == 'x')
                    map[i][j] = true;
            }
        }
        for (int i = 0; i < R; i++) {
            checker = false;
            recur(i, 0);
        }

        // for (int i = 0; i < R; i++) {
        // for (int j = 0; j < C; j++) {
        // System.out.print(check[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(cnt);
    }
}
