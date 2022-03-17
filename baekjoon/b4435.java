package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] gan = { 1, 2, 3, 3, 4, 10 };
        int[] sa = { 1, 2, 2, 2, 3, 5, 10 };
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int gansum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                gansum += gan[j] * Integer.parseInt(st.nextToken());

            }
            int sasum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                sasum += sa[j] * Integer.parseInt(st.nextToken());
            }
            System.out.print("Battle " + (i + 1) + ": ");
            if (gansum > sasum)
                System.out.println("Good triumphs over Evil");
            else if (sasum > gansum)
                System.out.println("Evil eradicates all trace of Good");
            else
                System.out.println("No victor on this battle field");
        }

    }
}
