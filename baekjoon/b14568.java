package baekjoon;

import java.util.Scanner;

public class b14568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A;
        int B;
        int C;
        int cnt = 0;
        for (C = 2; C < N; C += 2) {
            int temp = N - C;
            if (temp > 3)
                for (A = 1; A < temp; A++) {
                    B = temp - A;
                    if (B >= A + 2)
                        cnt++;
                }
        }
        System.out.println(cnt);
    }
}
