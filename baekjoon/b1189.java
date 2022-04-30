package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1189 {
    static int R;
    static int C;
    static int K;
    static char[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static boolean[][] check;

    static public int recur(int x, int y, int c) {
        int ret = 0;
        if (x == 0 && y == C - 1 && K == c)
            return 1;
        if (c > K)
            return 0;
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dy[i];
            int ny = y + dx[i];
            if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1 || check[nx][ny] || map[nx][ny] == 'T')
                continue;
            ret += recur(nx, ny, c + 1);
        }
        check[x][y] = false;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        check = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        System.out.println(recur(R - 1, 0, 1));
    }
}
