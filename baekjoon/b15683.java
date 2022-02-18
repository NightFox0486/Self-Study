package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15683 {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int direction;
    static List<CCTV> list;
    static int[] arr;

    static class CCTV {
        int type = 0;
        public int x;
        public int y;

        CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    static void checkStraight(char[][] map, int direction, int x, int y) {
        int sx = -1;
        int sy = -1;
        switch (direction) {
            case 0: {
                sx = x;
                sy = y + 1;
                if (sy > M - 1 || map[sx][sy] == '6')
                    return;
                if (!(map[sx][sy] == '1' || map[sx][sy] == '2' || map[sx][sy] == '3' || map[sx][sy] == '4'
                        || map[sx][sy] == '5'))
                    map[sx][sy] = '#';
                checkStraight(map, direction, sx, sy);
            }
                break;
            case 1: {
                sx = x + 1;
                sy = y;
                if (sx > N - 1 || map[sx][sy] == '6')
                    return;
                if (!(map[sx][sy] == '1' || map[sx][sy] == '2' || map[sx][sy] == '3' || map[sx][sy] == '4'
                        || map[sx][sy] == '5'))
                    map[sx][sy] = '#';
                checkStraight(map, direction, sx, sy);
            }
                break;
            case 2: {
                sx = x;
                sy = y - 1;
                if (sy < 0 || map[sx][sy] == '6')
                    return;
                if (!(map[sx][sy] == '1' || map[sx][sy] == '2' || map[sx][sy] == '3' || map[sx][sy] == '4'
                        || map[sx][sy] == '5'))
                    map[sx][sy] = '#';
                checkStraight(map, direction, sx, sy);
            }
                break;
            case 3: {
                sx = x - 1;
                sy = y;
                if (sx < 0 || map[sx][sy] == '6')
                    return;
                if (!(map[sx][sy] == '1' || map[sx][sy] == '2' || map[sx][sy] == '3' || map[sx][sy] == '4'
                        || map[sx][sy] == '5'))
                    map[sx][sy] = '#';
                checkStraight(map, direction, sx, sy);
            }
                break;
        }
    }

    static void getMin(int cur, char[][] map) {
        if (cur == list.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).type == 1) {
                    checkStraight(map, arr[i], list.get(i).x, list.get(i).y);
                } else if (list.get(i).type == 2) {
                    checkStraight(map, arr[i], list.get(i).x, list.get(i).y);
                    checkStraight(map, (arr[i] + 2) % 4, list.get(i).x, list.get(i).y);
                } else if (list.get(i).type == 3) {
                    checkStraight(map, arr[i], list.get(i).x, list.get(i).y);
                    checkStraight(map, (arr[i] + 1) % 4, list.get(i).x, list.get(i).y);
                } else if (list.get(i).type == 4) {
                    checkStraight(map, arr[i], list.get(i).x, list.get(i).y);
                    checkStraight(map, (arr[i] + 1) % 4, list.get(i).x, list.get(i).y);
                    checkStraight(map, (arr[i] + 2) % 4, list.get(i).x, list.get(i).y);
                } else if (list.get(i).type == 5) {
                    checkStraight(map, 0, list.get(i).x, list.get(i).y);
                    checkStraight(map, 1, list.get(i).x, list.get(i).y);
                    checkStraight(map, 2, list.get(i).x, list.get(i).y);
                    checkStraight(map, 3, list.get(i).x, list.get(i).y);
                }
            }
            min = Math.min(min, check(map));
            return;
        }
        for (int i = 0; i < 4; i++) {
            arr[cur] = i;
            getMin(cur + 1, map);
        }
    }

    static int check(char[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == '0')
                    cnt++;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == '#')
                    map[i][j] = '0';

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] != '0' && map[i][j] != '6')
                    list.add(new CCTV(map[i][j] - '0', i, j));
            }
        }
        arr = new int[list.size()];
        getMin(0, map);
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++) {
        // System.out.print(map[i][j] + " ");
        // }
        // System.out.println();
        // }
        System.out.println(min);
    }
}
