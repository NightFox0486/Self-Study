package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15656 {
    public static int N;
    public static int M;
    public static int[] input;
    public static int[] ans;
    public static StringBuilder sb;

    public static void recur(int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");

            return;
        }
        for (int i = 0; i < N; i++) {
            ans[cur] = input[i];
            recur(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        recur(0);
        System.out.println(sb);
    }
}
