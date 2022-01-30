package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            int N = str.length();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                if (i == 0 && str.charAt(0) == '0')
                    System.exit(0);
                arr[i] = str.charAt(i) - '0';
            }
            if (N == 1)
                System.out.println("yes");
            for (int i = 0; i < N / 2; i++) {
                if (arr[i] != arr[N - i - 1]) {
                    System.out.println("no");
                    break;
                }
                if (i == N / 2 - 1)
                    System.out.println("yes");
            }
        }
    }
}
