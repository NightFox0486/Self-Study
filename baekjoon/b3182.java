package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b3182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N + 1];
        boolean[][] check = new boolean[N + 1][N + 1];
        int[] cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            int index = i;
            check[i][i] = true;
            while (!check[i][input[index]]) {
                check[i][input[index]] = true;
                cnt[i]++;
                index = input[index];
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                ans = i;
            }
        }
        System.out.println(ans);
    }
}