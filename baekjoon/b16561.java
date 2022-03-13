package baekjoon;

import java.util.Scanner;

public class b16561 {
    static int N;
    static int K;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = N / 3 - 2;
        for (int i = K; i > 0; i--) {
            cnt += i;
        }
        System.out.println(cnt);
    }
}