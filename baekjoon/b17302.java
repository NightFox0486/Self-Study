package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17302 {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        // if B 이면 3->2 실행; W면 1
        System.setIn(new FileInputStream("baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        char[][] map = new char[N][M];
        // int[][] ans = new int[N][M];
        for (int i = 0; i < N; i++) { /////////////////////////// 입력 받은 값 배열에 매핑
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        } ///////////////////////////////////////////////////////////////////////////////
          // 변환 안되는 경우 -> B W 개수 측정 ???
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') {
                    sb.append("1");// ans[i][j] = doFirst();
                } else {
                    map[i][j] = 'W';
                    // doThird(map, i, j);
                    sb.append("3");// ans[i][j] = 3;// doSecond(map, i, j);
                }
            }
            sb.append("\n");
        }
        System.out.println(1);
        System.out.println(sb);
        // boolean possible = true;
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // if (map[i][j] == 'B')
        // possible = false;
        // }
        // }

        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.print(map[i][j]);
        // }
        // System.out.println();
        // }

        // if (possible) {
        // System.out.println(1);
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.print(ans[i][j]);
        // }
        // System.out.println();
        // }
        // } else
        // System.out.println(-1);
    }

    static int dy[] = { -1, 1, 0, 0, 0 };
    static int dx[] = { 0, 0, -1, 1, 0 };

    public static int doFirst() {
        return 1;
    }

    public static int doSecond(char[][] map, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int ny = x + dy[i];
            int nx = y + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) // 좌표값 자신과 배열범위를 넘어서면 스킵
                continue;
            if (map[ny][nx] == 'W') { // 좌표값에 인접한 색상을 반대로 변환
                map[ny][nx] = 'B';
            } else {
                map[ny][nx] = 'W';
            }
        }
        return 2;
    }

    public static int doThird(char[][] map, int x, int y) {
        for (int i = 0; i < 5; i++) {
            int ny = x + dy[i];
            int nx = y + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) // 배열범위를 넘어서면 스킵
                continue;
            if (map[ny][nx] == 'W') { // 좌표값에 인접한 색상을 반대로 변환
                map[ny][nx] = 'B';
            } else {
                map[ny][nx] = 'W';
            }
        }
        return 3;
    }
}
