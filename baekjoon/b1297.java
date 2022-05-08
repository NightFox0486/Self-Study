package baekjoon;

import java.util.Scanner;

public class b1297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        int h = (int) (H * Math.sqrt((double) D * D / (H * H + W * W)));
        int w = (int) (W * Math.sqrt((double) D * D / (H * H + W * W)));
        System.out.println(h + " " + w);
    }
}