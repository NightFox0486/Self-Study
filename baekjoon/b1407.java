package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1407 {
    static long recur(long input, long N) {
        if (N == 0)
            return input / 1 - input / 2;
        return recur(input, N - 1) + (1 << N) * ((input / (1 << N)) - (input / (1 << (N + 1))));
    }

    static long fx(long input) {
        int N = 0;
        long inputN = input;
        if (input == 0)
            return 0;
        if (input == 1)
            return 1;
        while (!(input == 1)) {
            input /= 2;
            N++;
        }
        return recur(inputN, N - 1) + (1 << N) * (inputN / (1 << N));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long ans = fx(B) - fx(A - 1);

        System.out.println(ans);
    }
}