package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2239 {
    static int N = 9;
    static int[][] map = new int[N][N];
    static int[] dy = { 0, 1 };
    static int[] dx = { 1, 0 };

    static void solve(int x, int y, int sum) {
        if (sum == 405 && x == N && y == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }
        // print();
        int ny = y + 1;
        int nx = x;
        if (ny == N) {
            ny = 0;
            nx = x + 1;
        }
        if (map[x][y] == 0) {
            for (int j = 1; j <= N; j++) {
                if (check(x, y, j)) {
                    map[x][y] = j;
                    solve(nx, ny, sum + map[x][y]);
                    map[x][y] = 0;
                }
            }
        } else
            solve(nx, ny, sum + map[x][y]);

    }

    static boolean check(int x, int y, int n) {
        boolean[] numcheck = new boolean[10];
        for (int i = 0; i < N; i++) { // 가로축 확인
            numcheck[map[x][i]] = true;
        }
        for (int i = 0; i < N; i++) { // 세로축 확인
            numcheck[map[i][y]] = true;
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) { // 3x3 블럭 체크
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                numcheck[map[i][j]] = true;
            }
        }
        if (numcheck[n])
            return false;
        else
            return true;
    }

    static void print() {
        System.out.println("===================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        solve(0, 0, 0);
    }
}
