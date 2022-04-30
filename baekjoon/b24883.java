package baekjoon;

import java.util.Scanner;

public class b24883 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        String str = "Naver Whale";
        if (ch == 'N' || ch == 'n')
            str = "Naver D2";
        System.out.println(str);
    }
}
