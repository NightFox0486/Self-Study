package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = { 1, 1, 2, 2, 2, 8 };
        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            ans[i] -= input[i];
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
