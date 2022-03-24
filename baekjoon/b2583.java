package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2583 {
    static int N;
    static int M;
    static boolean[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static void setting(int x1, int x2, int y1, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = true;
            }
        }
    }

    static int bfs(int x, int y) {
        int sum = 0;
        int[] p = { x, y };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(p);
        map[x][y] = true;
        sum++;
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int sx = c[0] + dy[i];
                int sy = c[1] + dx[i];
                if (sx > N - 1 || sy > M - 1 || sx < 0 || sy < 0 || map[sx][sy])
                    continue;
                queue.add(new int[] { sx, sy });
                map[sx][sy] = true;
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            int x1, x2, y1, y2;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            setting(x1, x2, y1, y2);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j])
                    list.add(bfs(i, j));
            }
        }
        Collections.sort(list);
        sb.append(list.size() + "\n");
        for (Integer integer : list) {
            sb.append(integer + " ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
