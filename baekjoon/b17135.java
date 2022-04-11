package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17135 {
    static int N;
    static int M;
    static int D;
    static int[][] input;
    static int[][] map;
    static int[] arr = new int[3];
    static boolean[] check;
    static int max = Integer.MIN_VALUE;

    static void solve(int cur) {
        if (cur == 3) {
            mapInit();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += shoot(arr);
                down();
                // print();
            }
            // System.out.println(cnt);
            max = Math.max(max, cnt);
            return;
        }
        for (int i = 0; i < M; i++) {
            if (check[i])
                continue;
            arr[cur] = i;
            check[i] = true;
            solve(cur + 1);
            check[i] = false;
        }
    }

    static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static int shoot(int[] n) {
        int cnt = 0;
        int r1 = N;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int k = 0; k < 3; k++) {
            int c1 = n[k];
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);
            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && getDistance(r1, c1, i, j) <= D) {
                        pq.add(new int[] { i, j, getDistance(r1, c1, i, j) });
                    }
                }
            }
            if (!pq.isEmpty()) {
                queue.add(pq.poll());
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (map[current[0]][current[1]] == 0)
                continue;
            map[current[0]][current[1]] = 0;
            cnt++;
        }
        return cnt;
    }

    static void down() {
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                map[i + 1][j] = map[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            map[0][i] = 0;
        }
    }

    static void mapInit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = input[i][j];
            }
        }
    }

    static void print() {
        System.out.println("--------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        map = new int[N][M];
        check = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(max);
    }
}
