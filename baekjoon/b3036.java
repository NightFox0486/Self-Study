package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3036 {
    static int[] input;

    static int getGcd(int a, int b) {
        if (a < b) {
            while (b % a != 0) {
                int temp = b;
                b = a;
                a = temp % a;
            }
            return a;
        } else if (a > b) {
            while (a % b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            int gcd = getGcd(input[0], input[i]);
            System.out.println((input[0] / gcd) + "/" + (input[i] / gcd));
        }
    }
}
