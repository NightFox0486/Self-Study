package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2563 {
    static boolean[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new boolean[100][100];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mapping(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(cnt);
    }

    static void mapping(int start_x, int start_y) {
        for (int i = start_x; i < start_x + 10; i++) {
            for (int j = start_y; j < start_y + 10; j++) {
                if (!map[i][j])
                    cnt++;
                map[i][j] = true;
            }
        }
    }
}
