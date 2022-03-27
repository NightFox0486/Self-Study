package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class b2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i] * (arr.length - i));
        }
        System.out.println(max);
    }
}
