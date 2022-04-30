package baekjoon;

import java.util.Scanner;

public class b5086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0)
                break;
            String ans = "neither";
            if (a / b != 0 && a % b == 0)
                ans = "multiple";
            if (b / a != 0 && b % a == 0)
                ans = "factor";
            System.out.println(ans);
        }
    }
}
