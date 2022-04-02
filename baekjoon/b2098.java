package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2098 {
    static int N;
    static int[][] map;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;
    static int start = 0;

    static void dfs(int cur, int from, int sum) {
        if (cur == N - 1) {
            if (map[from][start] == 0)
                return;
            sum += map[from][start];
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (from == i || start == i)
                continue;
            if (check[i])
                continue;
            if (map[from][i] == 0)
                continue;
            check[i] = true;
            dfs(cur + 1, i, sum + map[from][i]);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            start = i;
            check = new boolean[N];
            dfs(0, start, 0);
        }
        System.out.println(min);
    }
}
