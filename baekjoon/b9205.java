package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b9205 {
    static Point[] list;
    static int remain = 20;
    static Point start;
    static Point end;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int getDis(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static String bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (getDis(current, end) <= 1000) {
                return "happy";
            }
            List<Point> delList = new ArrayList<>();
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null)
                    continue;
                if (getDis(list[i], current) <= 1000) {
                    queue.add(list[i]);
                    list[i] = null;
                }
            }
        }
        return "sad";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            list = new Point[N];
            int index = 0;
            for (int j = 0; j < N + 2; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    start = new Point(x, y);
                } else if (j == N + 1) {
                    end = new Point(x, y);
                } else {
                    list[index++] = new Point(x, y);
                }
            }
            System.out.println(bfs());
        }
    }
}
