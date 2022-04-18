package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9291 {
    static int[][] map;
    static boolean checkAll;

    static boolean check(int x, int y) {
        boolean[] numcheck = new boolean[10];
        for (int i = 0; i < 9; i++) { // 가로축 확인
            if (numcheck[map[x][i]])
                return false;
            numcheck[map[x][i]] = true;
        }
        numcheck = new boolean[10];
        for (int i = 0; i < 9; i++) { // 세로축 확인
            if (numcheck[map[i][y]])
                return false;
            numcheck[map[i][y]] = true;
        }
        numcheck = new boolean[10];
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) { // 3x3 블럭 체크
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (numcheck[map[i][j]])
                    return false;
                numcheck[map[i][j]] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map = new int[9][9];
            checkAll = true;
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!check(i, j))
                        checkAll = false;
                }
            }
            String str;
            if (checkAll)
                str = "CORRECT";
            else
                str = "INCORRECT";
            System.out.println("Case " + t + ": " + str);
            if (t != T)
                br.readLine();
        }
    }
}
