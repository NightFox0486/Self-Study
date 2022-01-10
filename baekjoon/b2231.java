package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int n = 1;
        while (true) {
            if (isDivSum(n) == N) {
                bw.write(Integer.toString(n));
                break;
            }
            n++;
            if (n > N) {
                bw.write("0");
                break;
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    public static int isDivSum(int n) {
        int N = n;
        while (true) {
            N += n % 10;
            n /= 10;
            if (n < 10) {
                N += n;
                break;
            }
        }
        return N;
    }
}
