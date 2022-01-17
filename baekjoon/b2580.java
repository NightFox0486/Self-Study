package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2580 {
    static int N = 9;

    public static void main(String[] args) throws IOException {
        int[][] sudoku = new int[N][N];
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += sudoku[i][j];
                if (sudoku[i][j] == 0) {
                    if ((i % 3 == 1 && j % 3 == 1)) {
                        sudoku[i][j] = serching8Way(sudoku, i, j);
                        sum += sudoku[i][j];
                    }
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = serchingX(sudoku[i], j);
                        sum += sudoku[i][j];
                    }
                    if (sudoku[i][j] == 0) {
                        sudoku[i][j] = serchingY(sudoku, i, j);
                        sum += sudoku[i][j];
                    }

                }
                if (i == N - 1 && j == N - 1) {
                    if (sum != 405) {
                        i = sum = 0;
                        j = -1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(sudoku[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int serchingX(int[] map, int y) {
        int sum = 0;
        for (int j = 0; j < N; j++) {
            if (j == y)
                continue;
            if (map[j] == 0)
                return 0;
            sum += map[j];
        }
        return 45 - sum;
    }

    public static int serchingY(int[][] map, int x, int y) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i == x)
                continue;
            if (map[i][y] == 0)
                return 0;
            sum += map[i][y];
        }
        return 45 - sum;
    }

    public static int serching8Way(int[][] map, int x, int y) {
        int sum = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i == x && j == y)
                    continue;
                if (map[i][j] == 0)
                    return 0;
                sum += map[i][j];
            }
        }
        return 45 - sum;
    }

    public static int serching(int[][] map, int x, int y) {
        return 0;
    }
}
