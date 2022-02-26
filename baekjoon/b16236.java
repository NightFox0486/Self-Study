package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16236 {
    static int N;
    static int[][] map;
    static int sx;
    static int sy;
    static int slevel;
    static int ans = 0;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static Queue<Fish> queue = new PriorityQueue<>(
            (o1, o2) -> {
                int dis1 = getDistance(sx, sy, o1);
                int dis2 = getDistance(sx, sy, o2);
                return (dis1 == dis2) ? (o1.x == o2.x) ? o1.y - o2.y : o1.x - o2.x
                        : dis1 - dis2;
            });
    static Queue<Fish> fishlist = new PriorityQueue<>((o1, o2) -> o1.level - o2.level);

    static class Fish {
        int x;
        int y;
        int level;

        Fish(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }

    static int getDistance(int sx, int sy, Fish f) {
        boolean[][] check = new boolean[N][N];
        Queue<int[]> movequeue = new LinkedList<>();
        movequeue.add(new int[] { sx, sy, 0 });
        int min = Integer.MAX_VALUE;
        check[sx][sy] = true;
        while (!movequeue.isEmpty()) {
            int[] temp = movequeue.poll();
            if (temp[0] == f.x && temp[1] == f.y) {
                min = Math.min(min, temp[2]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dy[i];
                int ny = temp[1] + dx[i];
                if (nx > N - 1 || ny > N - 1 || nx < 0 || ny < 0 || map[nx][ny] > slevel)
                    continue;
                if (!check[nx][ny]) {
                    movequeue.add(new int[] { nx, ny, temp[2] + 1 });
                    check[nx][ny] = true;
                }
            }
        }
        return min;
    }

    static void refill_fish_levelup() {
        while (!fishlist.isEmpty() && fishlist.peek().level < slevel) {
            queue.add(fishlist.poll());
        }
    }

    static void refill_fishcurrent() {
        Queue<Fish> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        while (!list.isEmpty()) {
            queue.add(list.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sx = 0;
        sy = 0;
        slevel = 2;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                }
                if (map[i][j] != 9 && map[i][j] != 0)
                    fishlist.add(new Fish(i, j, map[i][j]));
            }
        }
        refill_fish_levelup();
        map[sx][sy] = 0;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Fish current = queue.poll();
            ans += getDistance(sx, sy, current);
            cnt++;
            sx = current.x;
            sy = current.y;
            refill_fishcurrent();
            map[sx][sy] = 0;
            if (cnt == slevel) {
                slevel++;
                cnt = 0;
                refill_fish_levelup();
            }
        }
        System.out.println(ans);
    }
}
