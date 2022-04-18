package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17143 {
    static int sum;
    static int R;
    static int C;
    static int M;
    static Shark[][] map;
    static PriorityQueue<Shark>[][] pq;
    static Queue<Shark> queue = new LinkedList<Shark>();
    static int[] dy = { 0, -1, 1, 0, 0 };
    static int[] dx = { 0, 0, 0, 1, -1 };

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public boolean equals(Shark obj) {
            if (this.r == obj.r && this.c == obj.c && this.s == obj.s && this.d == obj.d && this.z == obj.z)
                return true;
            return false;
        }
    }

    static void initShark() {
        for (Shark s : queue) {
            map[s.r][s.c] = s;
        }
        print();
    }

    static void getShark(int c) {
        for (int i = 0; i < R; i++) {
            if (map[i][c] != null) {
                sum += map[i][c].z;
                while (true) {
                    Shark current = queue.poll();
                    if (map[i][c] != null && current.equals(map[i][c]))
                        break;
                    queue.add(current);
                }
                map[i][c] = null;
                return;
            }
        }
    }

    static void move() {
        map = new Shark[R][C];
        Iterator iter = queue.iterator();
        while (iter.hasNext()) {
            Shark current = (Shark) iter.next();
            int nx = current.r;
            int ny = current.c;
            for (int i = 0; i < current.s; i++) {
                nx += dy[current.d];
                ny += dx[current.d];
                if (nx < 0) {
                    current.d = 2;
                    nx = 1;
                }
                if (nx > R - 1) {
                    current.d = 1;
                    nx = R - 2;
                }
                if (ny < 0) {
                    current.d = 3;
                    ny = 1;
                }
                if (ny > C - 1) {
                    current.d = 4;
                    ny = C - 2;
                }
            }
            current.r = nx;
            current.c = ny;
            pq[nx][ny].add(current);
        }
        queue.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = pq[i][j].poll();
                if (map[i][j] != null)
                    queue.add(map[i][j]);
                pq[i][j].clear();
            }
        }
        print();
    }

    static void print() {
        System.out.println("===========================");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == null)
                    System.out.print("0 ");
                else
                    System.out.print(map[i][j].z + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (M != 0) {
            sum = 0;
            pq = new PriorityQueue[R][C];
            map = new Shark[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    pq[i][j] = new PriorityQueue<>((a, b) -> b.z - a.z);
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                queue.add(new Shark(r - 1, c - 1, s, d, z));
            }
            initShark();
            for (int i = 0; i < C; i++) {
                getShark(i);
                move();
            }
        }
        System.out.println(sum);
    }
}
