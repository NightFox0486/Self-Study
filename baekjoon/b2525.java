package baekjoon;

import java.util.Scanner;

public class b2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int result = A * 60 + B + C;
        System.out.println((result / 60) % 24 + " " + result % 60);
    }
}
