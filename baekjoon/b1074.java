package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {
    static int N, R, C;
    // static int[][] arr;
    static int cnt = 0;

    // static void recur(int N, int start_x, int start_y) {
    // if (N == 1) {
    // arr[start_x][start_y] = cnt++;
    // arr[start_x][start_y + N] = cnt++;
    // arr[start_x + N][start_y] = cnt++;
    // arr[start_x + N][start_y + N] = cnt++;
    // return;
    // }
    // if (R < (1 << (N - 1)) + start_x && C < (1 << (N - 1)) + start_y) {
    // recur(N - 1, start_x, start_y);
    // }
    // if (R < (1 << (N - 1)) + start_x && C >= (1 << (N - 1)) + start_y) {
    // cnt += (1 << (N - 1)) * (1 << (N - 1));
    // recur(N - 1, start_x, start_y + (1 << (N - 1)));
    // }
    // if (R >= (1 << (N - 1)) + start_x && C < (1 << (N - 1)) + start_y) {
    // cnt += (1 << (N - 1)) * (1 << (N - 1)) * 2;
    // recur(N - 1, start_x + (1 << (N - 1)), start_y);
    // }
    // if (R >= (1 << (N - 1)) + start_x && C >= (1 << (N - 1)) + start_y) {
    // cnt += (1 << (N - 1)) * (1 << (N - 1)) * 3;
    // recur(N - 1, start_x + (1 << (N - 1)), start_y + (1 << (N - 1)));
    // }
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // arr = new int[1 << N][1 << N];
        int start_X = 0;
        int start_Y = 0;
        while (N != 1) {
            int compare = 1 << (N - 1);
            int compare2 = compare * compare;
            int compare_X = compare + start_X;
            int compare_Y = compare + start_Y;
            if (R < compare_X && C >= compare_Y) {
                cnt += compare2;
                start_Y += compare;
            }
            if (R >= compare_X && C < compare_Y) {
                cnt += compare2 * 2;
                start_X += compare;
            }
            if (R >= compare_X && C >= compare_Y) {
                cnt += compare2 * 3;
                start_X += compare;
                start_Y += compare;
            }
            N--;
        }
        int ans = cnt + (R - start_X) + (C - start_Y) + 1;
        if (R % 2 == 0 && C % 2 == 0)
            ans--;
        // recur(N, 0, 0);
        System.out.println(ans);
    }
}
