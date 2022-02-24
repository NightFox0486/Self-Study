package baekjoon;

import java.util.Scanner;

public class b15736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long N2 = 1;
        long sum = 0;
        long ans = 1;
        long cnt = 1;
        while (sum < N) {
            N2 *= 2;
            sum += N2;
            sum += 1;
            cnt++;
        }
        ans = cnt - 1;
        System.out.println(ans);
    }
}
