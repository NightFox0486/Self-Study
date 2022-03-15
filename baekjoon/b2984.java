package baekjoon;

import java.util.Scanner;

public class b2984 {
    public static void main(String[] args) {
        String[] str = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        int[] Mon = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] Monsum = new int[13];
        Monsum[0] = 0;
        for (int i = 1; i < 13; i++) {
            Monsum[i] = Monsum[i - 1] + Mon[i];
        }
        int index = 2;
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int M = sc.nextInt();
        index += Monsum[M - 1];
        index += D;
        index %= 7;
        System.out.println(str[index]);
    }
}
