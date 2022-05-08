package baekjoon;

import java.util.Scanner;

public class b9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] dp = new boolean[N + 5];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = true;
        for (int i = 5; i < N + 1; i++) {
            if (dp[i - 1] && dp[i - 3] && dp[i - 4])
                dp[i] = false;
            else
                dp[i] = true;
        }
        if (dp[N])
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
