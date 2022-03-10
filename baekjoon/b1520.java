package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1520 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static int recur(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dy[i];
                int ny = y + dx[i];
                if (nx > N - 1 || ny > M - 1 || nx < 0 || ny < 0 || map[x][y] <= map[nx][ny])
                    continue;
                dp[x][y] += recur(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        recur(0, 0);

        System.out.println(dp[0][0]);
    }
}