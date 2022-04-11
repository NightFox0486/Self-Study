package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14502 {
    static int N;
    static int M;
    static int[][] input;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static List<int[]> spreadList = new LinkedList<>();
    static Queue<int[]> unspreadList = new LinkedList<>();
    static List<int[]> buildList = new ArrayList<>();
    static Queue<int[]> unbuildList = new LinkedList<>();
    static int[] wall = new int[3];
    static boolean[] wallcheck;
    static int max = Integer.MIN_VALUE;

    static void spread() {
        for (int i = 0; i < spreadList.size(); i++) {
            Queue<int[]> spreading = new LinkedList<>();
            spreading.offer(new int[] { spreadList.get(i)[0], spreadList.get(i)[1] });
            while (!spreading.isEmpty()) {
                int[] current = spreading.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dy[j];
                    int ny = current[1] + dx[j];
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || input[nx][ny] != 0)
                        continue;
                    input[nx][ny] = 2;
                    spreading.offer(new int[] { nx, ny });
                    unspreadList.offer(new int[] { nx, ny });
                }
            }
        }
    }

    static void unspread() {
        while (!unspreadList.isEmpty()) {
            int[] current = unspreadList.poll();
            input[current[0]][current[1]] = 0;
        }
    }

    static void build(int cur) {
        if (cur == 3) {
            // print();
            for (int i = 0; i < 3; i++) {
                input[buildList.get(wall[i])[0]][buildList.get(wall[i])[1]] = 1;
                unbuildList.offer(new int[] { buildList.get(wall[i])[0], buildList.get(wall[i])[1] });
            }
            // print();
            spread();
            // System.out.println("spread");
            // print();
            check();
            unspread();
            // System.out.println("unspread");
            // print();
            unbuild();
            // System.out.println("unbuild");
            // print();
            return;
        }
        for (int i = 0; i < buildList.size(); i++) {
            if (wallcheck[i])
                continue;
            wall[cur] = i;
            wallcheck[i] = true;
            build(cur + 1);
            wallcheck[i] = false;
        }
    }

    static void unbuild() {
        while (!unbuildList.isEmpty()) {
            int[] current = unbuildList.poll();
            input[current[0]][current[1]] = 0;
        }
    }

    static void check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

    static void print() {
        System.out.println("--------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (input[i][j] == 0)
                    buildList.add(new int[] { i, j });
                if (input[i][j] == 2)
                    spreadList.add(new int[] { i, j });
                wallcheck = new boolean[buildList.size()];
            }
        }
        build(0);
        System.out.println(max);
    }
}