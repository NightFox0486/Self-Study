package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2873 {
    static int R;
    static int C;
    static int[][] map;
    static char[] max_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        int cnt = 0;
        if (R % 2 == 1 && C % 2 == 1) {
            for (int i = 0; i < C / 2 + 1; i++) {
                for (int j = 0; j < R - 1; j++) {
                    sb.append('D');
                }
                if (i == C / 2)
                    break;
                sb.append('R');
                for (int j = 0; j < R - 1; j++) {
                    sb.append('U');
                }
                sb.append('R');
            }
        } else if (R % 2 == 1 && C % 2 == 0) {
            for (int i = 0; i < R / 2 + 1; i++) {
                for (int j = 0; j < C - 1; j++) {
                    sb.append('R');
                }
                if (i == R / 2)
                    break;
                sb.append('D');
                for (int j = 0; j < C - 1; j++) {
                    sb.append('L');
                }
                sb.append('D');
            }
        } else if (R % 2 == 0 && C % 2 == 1) {
            for (int i = 0; i < C / 2 + 1; i++) {
                for (int j = 0; j < R - 1; j++) {
                    sb.append('D');
                }
                if (i == C / 2)
                    break;
                sb.append('R');
                for (int j = 0; j < R - 1; j++) {
                    sb.append('U');
                }
                sb.append('R');
            }
        } else { /////////////////// 최소의 인덱스 값을 찾고 그 곳만 회피하여 이동

        }
        System.out.println(sb);
    }
}