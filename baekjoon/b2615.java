package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 검은 바둑알 = 1, 흰 바둑알 = 2
// 첫 줄에 승부 x = 0, 검은색 승 = 1, 흰색 승 = 2
// 둘째 줄에 승리 바둑알 가장 왼쪽 바둑알의 가로 세로 인덱스를 출력
public class b2615 {

    static public int N = 19;
    static public int[][] map = new int[N][N];
    static public int[][][] map3 = new int[N][N][4];
    static public int[] dy = { 0, 1, 1, -1 };
    static public int[] dx = { 1, 0, 1, 1 };

    static public int CheckWin(int x, int y, int cur) { // ************* 바운더리 체크 할것 (완료)
        int stoneColor = map[x][y];
        if (cur != -1) { ///////////////////////////////////// 이전에 진행했던 방향만 체크해서 재귀로 탐색
            int sy = x + dy[cur];
            int sx = y + dx[cur];
            if (sy > N - 1 || sx > N - 1 || sx < 0 || sy < 0)
                return 0;
            if (map[sy][sx] == stoneColor) { //////////////////// 현재 좌표랑 다음 방향 일치 하면 값을 +1 해서 반환
                return 1 + CheckWin(sy, sx, cur);
            } else
                return 0;
        } else {
            for (int i = 0; i < 4; i++) {
                int sy = x + dy[i];
                int sx = y + dx[i];
                if (sy > N - 1 || sx > N - 1 || sx < 0 || sy < 0)
                    continue;
                if (map[sy][sx] == stoneColor) {
                    map3[x][y][i] = CheckWin(sy, sx, i) + 1;
                    // System.out.println("x:"+x+"y:"+y+"a:"+map3[x][y][i]);
                    if (map3[x][y][i] == 4) {// 수색한 결과가 4개이면 이전 값 탐색후 결과 리턴
                        sy = x + (dy[i] * -1);
                        sx = y + (dx[i] * -1);
                        if (!(sy > N - 1 || sx > N - 1 || sx < 0 || sy < 0))
                            if (map[sy][sx] == stoneColor)
                                return 0;
                        return 1;
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("baekjoon/input.txt"));
        // 구현하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) // 현재 참조중인 좌표의 값이 0이면 Skip
                    continue;
                if (CheckWin(i, j, -1) == 1) {
                    System.out.println(map[i][j] + "\n" + (i + 1) + " " + (j + 1));
                    System.exit(0);
                }
            }
        }
        System.out.println("0");

    }

}
