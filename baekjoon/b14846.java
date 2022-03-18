package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b14846 {
    static int N;
    static int Q;
    static int[][] map;
    static int[][] sub_map;
    static int[][] sum_map;

    static void getSub_map(int x, int y) {
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                set.add(map[i][j]);
            }
        }
        sub_map[x][y] = set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        sub_map = new int[N + 1][N + 1];
        sum_map = new int[N + 1][N + 1]; // index 0 = padding
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                getSub_map(i, j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum_map[i][j] = sub_map[i][j] + sum_map[i - 1][j] + sum_map[i][j - 1] - sum_map[i - 1][j - 1];
            }
        }
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(sum_map[x2][y2] - sum_map[x1 - 1][y2] - sum_map[x2][y1 - 1] + sum_map[x1 - 1][y1 - 1] + "\n");
        }
        System.out.print(sb);
    }
}

/*
 * input
 * 0 0 0 0
 * 0 1 2 3
 * 0 3 2 1
 * 0 5 6 3
 * sub_map
 * 0 0 0 0
 * 0 1 2 3
 * 0 2 3 3
 * 0 3 5 5
 * sum_map
 * 0 0 0 0
 * 0 1 3 6
 * 0 3 8 14
 * 0 6 16 27
 */

// 0 0 0 0 0 1 2 3 0 2 3 0 3 4 5