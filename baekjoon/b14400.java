package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b14400 {
    static int N;
    static int minX;
    static int maxX;
    static int minY;
    static int maxY;
    static Point[] list;
    static int sum;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int getDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new Point[N];
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
            list[i] = new Point(x, y);
        }
        int midX = (maxX + minX) / 2 + 1;
        int midY = (maxY + minY) / 2 + 4;
        for (int i = 0; i < N; i++) {
            sum += getDis(list[i].x, list[i].y, midX, midY);
        }
        System.out.println(midX + " " + midY);
        System.out.println(sum);
    }
}