package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17304 {
    static int N;
    static int M;
    static List[] list;
    static int[] check;
    static Stack<Integer> stack = new Stack<Integer>();
    static int cnt = 0;

    static void solve(int cur) {
        for (int i = 0; i < list[cur].size(); i++) {
            int temp = (int) list[cur].get(i);
            if (check[temp] == 0) {
                if (temp < cur && list[temp].contains(cur))
                    continue;
                check[temp]++;
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        check = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }
        for (int i = 1; i <= N; i++) {
            solve(i);
        }

        if (cnt == N)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
