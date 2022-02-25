package baekjoon;

import java.util.Scanner;

public class b15736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long cnt = 1;
        for (int i = 2; i <= N; i++) {
            if (i * i > N)
                break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
