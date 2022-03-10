package baekjoon;

import java.util.Scanner;

public class b17945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int ans1 = (int) (-2 * A + Math.sqrt((4 * A * A) - (4 * B))) / 2;
        int ans2 = (int) (-2 * A - Math.sqrt((4 * A * A) - (4 * B))) / 2;
        if (ans1 == ans2)
            System.out.println(ans1);
        else if (ans1 < ans2)
            System.out.println(ans1 + " " + ans2);
        else
            System.out.println(ans2 + " " + ans1);
    }
}
