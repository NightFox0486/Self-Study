package baekjoon;

import java.util.Scanner;

public class b2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int k = Math.min(N / 2, M);
        while (K > (N - k * 2) + (M - k)) {
            k--;
        }
        System.out.println(k);
    }
}
