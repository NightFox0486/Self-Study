package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14501 {
    static int N;
    static int[][] input;
    static int max = Integer.MIN_VALUE;

    static void recur(int cur, int total) {
        if (cur > N) {
            return;
        }

        if (cur == N) {
            max = Math.max(max, total);
            return;
        }

        recur(cur + input[cur][0], total + input[cur][1]);
        recur(cur + 1, total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        input = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        System.out.println(max);
    }
}