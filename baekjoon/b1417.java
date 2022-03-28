package baekjoon;

import java.util.Scanner;

public class b1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int first = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int index = 0;
        int cnt = 0;
        int[] another = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            another[i] = sc.nextInt();
        }
        while (true) {
            for (int i = 0; i < N - 1; i++) {
                if (max < another[i]) {
                    max = another[i];
                    index = i;
                }
            }
            if (max >= first) {
                first++;
                another[index]--;
                cnt++;
            } else {
                break;
            }
            max = Integer.MIN_VALUE;
            index = 0;
        }
        System.out.println(cnt);
    }
}
