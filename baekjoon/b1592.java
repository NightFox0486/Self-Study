package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class b1592 {
    static int N;
    static int M;
    static int L;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        int[] check = new int[N + 1];
        int index = 1;
        int cnt = 0;
        check[index]++;
        while (true) {
            if (M == 1)
                break;
            if (check[index] % 2 == 0) {
                index = (index + N - L) % N;
            } else {
                index = (index + L) % N;
            }
            check[index]++;
            cnt++;
            if (check[index] == M)
                break;
        }
        System.out.println(cnt);
    }
}
