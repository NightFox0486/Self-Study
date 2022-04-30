package baekjoon;

import java.util.Scanner;

public class b2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int gcd;
        int tempA = A;
        int tempB = B;
        if (A < B) {
            while (B % A != 0) {
                int temp = B;
                B = A;
                A = temp % A;
            }
            gcd = A;
        } else {
            while (A % B != 0) {
                int temp = A;
                A = B;
                B = temp % B;
            }
            gcd = B;
        }
        System.out.println(gcd);
        System.out.println(((tempA * tempB) / gcd));
    }
}
