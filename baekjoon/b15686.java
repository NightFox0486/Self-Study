package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15686 {
    static int r;
    static int c;
    static int N;
    static int M;
    static int[][] map;
    static List<Point> houselist = new ArrayList<Point>();
    static List<Point> list = new ArrayList<Point>();
    static int total_chicken = 0;
    static boolean[] check;
    static int[] selected_chicken;
    static int min = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void recur(int cur, int start) {
        if (cur == M) {
            int sum = 0;
            for (int i = 0; i < houselist.size(); i++) {
                int min_distance = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    min_distance = Math.min(min_distance, getDistance(houselist.get(i), list.get(selected_chicken[j])));
                }
                sum += min_distance;
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = start; i < total_chicken; i++) {
            if (check[i])
                return;
            selected_chicken[cur] = i;
            check[i] = true;
            recur(cur + 1, i + 1);
            check[i] = false;
        }
    }

    static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected_chicken = new int[M];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    houselist.add(new Point(i, j));
                if (map[i][j] == 2)
                    list.add(new Point(i, j));
            }
        }
        total_chicken = list.size();
        check = new boolean[total_chicken];
        recur(0, 0);
        System.out.println(min);
    }
}
