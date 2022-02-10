package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// import java.util.LinkedList;
import java.util.Stack;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class b2667 {
    static int N;
    static int[] dy = { 0, 0, -1, 1 };
    static int[] dx = { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][] check;
    static ArrayList<Integer> al = new ArrayList<>();
    static int cnt = 0;

    public static void dfs(Point p) {
        Stack<Point> stack = new Stack<>();
        int tempcnt = 0;
        stack.add(p);
        check[p.x][p.y] = true;
        while (!stack.isEmpty()) {
            Point current = stack.pop();
            tempcnt++;
            for (int i = 0; i < 4; i++) {
                int sx = current.x + dy[i];
                int sy = current.y + dx[i];
                if (sx > N - 1 || sy > N - 1 || sx < 0 || sy < 0)
                    continue;
                if (!check[sx][sy] && map[sx][sy] == 1) {
                    check[sx][sy] = true;
                    stack.add(new Point(sx, sy));
                }
            }
        }
        al.add(tempcnt);
    }

    // public static void bfs(Point p) {
    // Queue<Point> queue = new LinkedList<>();
    // int tempcnt = 0;
    // queue.add(p);
    // check[p.x][p.y] = true;
    // while (!queue.isEmpty()) {
    // Point current = queue.poll();
    // tempcnt++;
    // for (int i = 0; i < 4; i++) {
    // int sx = current.x + dy[i];
    // int sy = current.y + dx[i];
    // if (sx > N - 1 || sy > N - 1 || sx < 0 || sy < 0)
    // continue;
    // if (!check[sx][sy] && map[sx][sy] == 1) {
    // check[sx][sy] = true;
    // queue.add(new Point(sx, sy));
    // }
    // }
    // }
    // al.add(tempcnt);
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    dfs(new Point(i, j));
                }
            }
        }
        Collections.sort(al);
        System.out.println(al.size());
        for (Integer temp : al) {
            System.out.println(temp);
        }
    }
}
