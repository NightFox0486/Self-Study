package baekjoon;

import java.util.Scanner;

public class b20310 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        char[] input = temp.toCharArray();
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '0')
                cnt0++;
            if (temp.charAt(i) == '1') {
                cnt1++;
            }
        }
        cnt0 /= 2;
        cnt1 /= 2;
        for (int i = 0; i < input.length; i++) {
            if (cnt1 != 0) {
                if (input[i] == '1') {
                    input[i] = ' ';
                    cnt1--;
                }
            }
        }
        for (int i = input.length - 1; i >= 0; i--) {
            if (cnt0 != 0) {
                if (input[i] == '0') {
                    input[i] = ' ';
                    cnt0--;
                }
            }
        }
        System.out.println(String.copyValueOf(input).replaceAll(" ", ""));
    }
}
