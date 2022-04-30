package baekjoon;

import java.util.Scanner;

public class b1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] pascalTriangle = new long[31][31];
        pascalTriangle[0][0] = 1;
        for (int i = 1; i < 31; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    pascalTriangle[i][j] = 1;
                else
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long ans = 1;
            ans = pascalTriangle[b][b - a];
            System.out.println(ans);
        }
    }
}
