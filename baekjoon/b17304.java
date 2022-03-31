package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class b17304 {
    static int N;
    static int M;
    static int[] node;
    static int[][] map;
    static int cnt = 0;
    static int cnt_with = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new LinkedList<Integer>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new int[N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            if (node[to] != -1)
                node[to] = 1;
            if (map[to][from] == 1) {
                node[from] = -1;
                node[to] = -1;
            }
        }
        for (int j = 1; j < N + 1; j++) {
            if (node[j] == 0) {
                cnt++;
            }
            if (node[j] == -1) {
                cnt_with++;
            }
        }
        cnt_with /= 2;
    }
}
