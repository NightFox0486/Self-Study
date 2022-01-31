package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long result = 0;

        for (long i = 1; i <= B; i *= 2) {
            result += (B / i - B / (2 * i)) * i - ((A - 1) / i - (A - 1) / (2 * i)) * i;
            System.out.println(result);
        }

        System.out.print(result);
    }
}
