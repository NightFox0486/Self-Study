package Range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_삼복치 {
    static int[] min = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
    static char[][] map;
    static boolean[][] check;
    static int[][] bokchi;
    static int bokchi_cnt = 0;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;
    static int t;

    static void recur(int x, int y, int cnt) {
        if (check[x][y])
            return;
        if (map[x][y] == 'B' || map[x][y] == 'C' || map[x][y] == '_') {
            if (min[bokchi_cnt] > cnt)
                min[bokchi_cnt] = cnt;
            if (bokchi_cnt == 2) {
                ans = Math.min(ans, min[0] + min[1] + min[2]);
                return;
            }
            check[x][y] = true;
            recur(bokchi[++bokchi_cnt][0], bokchi[bokchi_cnt][1], 0);
            if (min[bokchi_cnt] == Integer.MAX_VALUE) {
                ans = -1;
            }
            check[x][y] = false;
        }
        for (int i = 0; i < 4; i++) {
            int sx = x + dy[i];
            int sy = y + dx[i];
            if (sx > N - 1 || sy > M - 1 | sx < 0 || sy < 0 || map[sx][sy] == '#')
                continue;
            check[x][y] = true;
            recur(sx, sy, cnt + 1);
            check[x][y] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        // 복치 소환 위치에 check true 할것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            check = new boolean[N][M];
            bokchi = new int[3][2];
            for (int i = 0; i < N; i++)
                map[i] = br.readLine().toCharArray();
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                bokchi[i][0] = Integer.parseInt(st.nextToken()) - 1;
                bokchi[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }
            recur(bokchi[0][0], bokchi[0][1], 0);
            System.out.println("#" + t + " " + ans);
            ans = Integer.MAX_VALUE;
            min[0] = Integer.MAX_VALUE;
            min[1] = Integer.MAX_VALUE;
            min[2] = Integer.MAX_VALUE;
            bokchi_cnt = 0;
        }
    }
}