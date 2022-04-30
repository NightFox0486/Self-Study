package baekjoon;

import java.util.Scanner;

public class b1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        cnt += n / 5;
        cnt += n / 25;
        cnt += n / 125;
        System.out.println(cnt);
    }
}
