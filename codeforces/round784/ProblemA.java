package codeforces.round784;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int rank = sc.nextInt();
            if (rank <= 1399) {
                System.out.println("Division 4");
            } else if (rank <= 1599) {
                System.out.println("Division 3");
            } else if (rank <= 1899) {
                System.out.println("Division 2");
            } else {
                System.out.println("Division 1");
            }
        }
    }
}
