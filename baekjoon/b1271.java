package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class b1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());
        BigInteger[] ans = N.divideAndRemainder(K);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}