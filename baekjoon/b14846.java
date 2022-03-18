package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14846 {
    static int N;
    static int Q;
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1][11];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k <= 10; k++)
                    map[i][j][k] += map[i][j - 1][k] + map[i - 1][j][k] - map[i - 1][j - 1][k];
                map[i][j][Integer.parseInt(st.nextToken())]++;
            }
        }
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] result = new int[11];
            for (int k = 0; k <= 10; k++) {
                result[k] = map[x2][y2][k] - map[x1 - 1][y2][k] - map[x2][y1 - 1][k] + map[x1 - 1][y1 - 1][k];
                if (result[k] != 0)
                    cnt++;
            }

            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }
}