package baekjoon;

import java.util.Scanner;

public class b11050 {
    static int[] fact;

    static void setFact() {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        fact = new int[N + 1];
        setFact();
        System.out.println(fact[N] / (fact[K] * fact[N - K]));
    }
}
