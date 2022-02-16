package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2961 {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    static void recur(int cur, int cnt, int S, int B) {
        if (cnt != 0) {
            if (min > Math.abs(S - B))
                min = Math.abs(S - B);
        }
        if (cur == N)
            return;

        recur(cur + 1, cnt + 1, S * arr[cur][0], B + arr[cur][1]);
        recur(cur + 1, cnt, S, B);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, 1, 0);
        System.out.println(min);
    }
}
