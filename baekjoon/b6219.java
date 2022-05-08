package baekjoon;

import java.util.Scanner;

public class b6219 {
    static boolean[] prime;

    static void setPrime() {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i])
                continue;
            int j = 2;
            while (true) {
                if (i * j < prime.length)
                    prime[i * j] = true;
                else
                    break;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prime = new boolean[40000001];
        int A = sc.nextInt();
        int B = sc.nextInt();
        int D = sc.nextInt();
        int cnt = 0;
        setPrime();
        for (int i = A; i <= B; i++) {
            if (!prime[i]) {
                if (String.valueOf(i).contains(String.valueOf(D))) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
