package baekjoon;

import java.util.Scanner;

public class b11051 {
    static long[][] pascal;
    static long P = 10007;

    static void setFact() {
        pascal[0][0] = 1;
        for (int i = 1; i < pascal.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    pascal[i][j] = 1;
                } else if (j == 0) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % P;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        pascal = new long[N + 1][N + 1];
        setFact();
        System.out.println(pascal[N][K]);
    }
}
