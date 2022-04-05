package baekjoon;

import java.util.Scanner;

public class b2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counter = new int[7];
        counter[sc.nextInt()]++;
        counter[sc.nextInt()]++;
        counter[sc.nextInt()]++;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i < 7; i++) {
            if (counter[i] >= max) {
                max = counter[i];
                index = i;
            }
        }
        int result = 0;
        if (max == 3) {
            result = 10000 + (index * 1000);
        } else if (max == 2) {
            result = 1000 + (index * 100);
        } else if (max == 1) {
            result = (index * 100);
        }
        System.out.println(result);
    }
}
