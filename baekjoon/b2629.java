package baekjoon;

import java.util.Scanner;

public class b2629 {
    static boolean[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new boolean[N + 1][40009]; // 입력 받을때 마다 갱신 하기 위한 2차원 배열
        for (int i = 1; i <= N; i++) {
            int temp = sc.nextInt();
            for (int j = 0; j <= 30; j++) {
                if (dp[i - 1][j]) { // 그전에 입력 받았을때 추로 잴 수 있었던 위치인지 판단.
                    dp[i][j] = true; // 이전에 값을 현재 dp에도 갱신 하고 새로들어온 값에서 부터 이전에 가능했던 값에다 +- 로 잴 수 있다고 표기해줌
                    if (temp - j >= 0)
                        dp[i][temp - j] = true;
                    if (temp + j < 40001)
                        dp[i][temp + j] = true;
                }
                dp[i][temp] = true;
            }
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (dp[N][num]) { // 완성된 마지막 dp배열로 가능한지 판단
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
