package codeforces.round784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemG {
    static char[][] map;
    static int R;
    static int C;

    static void solve() {
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    gravity(i, j);
                }
            }
        }
    }

    static void gravity(int i, int j) {
        int dy = 1;
        int dx = 0;
        int nx = i;
        int ny = j;
        while (true) {
            nx += dy;
            ny += dx;
            if (nx > R - 1 || map[nx][ny] == '*' || map[nx][ny] == 'o')
                break;
            map[nx - 1][ny] = '.';
            map[nx][ny] = '*';
        }
    }

    static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            for (int j = 0; j < R; j++) {
                String temp = br.readLine();
                for (int k = 0; k < C; k++) {
                    map[j][k] = temp.charAt(k);
                }
            }
            solve();
            printMap();
        }
    }
}
