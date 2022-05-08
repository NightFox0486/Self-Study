package baekjoon;

import java.util.Scanner;

public class b1550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < chs.length; i++) {
            if (i == chs.length - 1) {
                if (chs[i] >= 'A' && chs[i] <= 'F') {
                    ans += chs[i] - 'A' + 10;
                } else {
                    ans += chs[i] - '0';
                }
            } else {
                if (chs[i] >= 'A' && chs[i] <= 'F') {
                    ans += (chs[i] - 'A' + 10) * Math.pow(16, chs.length - i - 1);
                } else {
                    ans += (chs[i] - '0') * Math.pow(16, chs.length - i - 1);
                }
            }
        }
        System.out.println(ans);
    }
}