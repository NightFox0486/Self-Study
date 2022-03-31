package baekjoon;

import java.util.Scanner;

public class b1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] memoi = new int[N + 1];

        memoi[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            memoi[i] = memoi[i - 1] + 1;
            if (i % 2 == 0)
                memoi[i] = Math.min(memoi[i], memoi[i / 2] + 1);
            if (i % 3 == 0)
                memoi[i] = Math.min(memoi[i], memoi[i / 3] + 1);
        }
        System.out.println(memoi[N]);
    }
}
