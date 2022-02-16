package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1992 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;

    static void recur(int N, int x, int y) {
        if (N == 1) {
            sb.append(arr[y][x]);
            return;
        }
        boolean check = true;
        for (int i = y; i < y + N; i++) {
            if (!check)
                break;
            for (int j = x; j < x + N; j++) {
                if (arr[y][x] != arr[i][j]) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            sb.append(arr[y][x]);
            return;
        }

        sb.append("(");
        recur(N / 2, x, y);
        recur(N / 2, x + N / 2, y);
        recur(N / 2, x, y + N / 2);
        recur(N / 2, x + N / 2, y + N / 2);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }
        recur(N, 0, 0);
        System.out.println(sb);
    }
}
