package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int a_n = 1;
        int b_n = 1;
        int check = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j == n && w == (a * i) + (b * j)) {
                    a_n = i;
                    b_n = j;
                    check++;
                }
            }
        }
        if (check == 1)
            System.out.println(a_n + " " + b_n);
        else
            System.out.println(-1);
    }
}