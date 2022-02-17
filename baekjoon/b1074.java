package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1074 {
    static int N, R, C;
    static int[][] arr;
    static int cnt = 0;

    static void recur(int N, int start_x, int start_y) {
        if (N == 1) {
            arr[start_x][start_y] = cnt++;
            arr[start_x][start_y + N] = cnt++;
            arr[start_x + N][start_y] = cnt++;
            arr[start_x + N][start_y + N] = cnt++;
            return;
        }
        if (R < (1 << (N / 2)) && C < (1 << (N / 2))) {
            recur(N - 1, start_x, start_y);
        }
        if (R < (1 << (N / 2)) && C >= (1 << (N / 2))) {
            cnt += (1 << N);
            recur(N - 1, start_x, start_y + (1 << (N - 1)));
        }
        if (R >= (1 << (N / 2)) && C < (1 << (N / 2))) {
            cnt += (1 << N) * 2;
            recur(N - 1, start_x + (1 << (N - 1)), start_y);
        }
        if (R >= (1 << (N / 2)) && C >= (1 << (N / 2))) {
            cnt += (1 << N) * 3;
            recur(N - 1, start_x + (1 << (N - 1)), start_y + (1 << (N - 1)));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[1 << N][1 << N];
        recur(N, R, C);
        System.out.println(arr[R][C]);
    }
}
