package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3985 {
    static int L;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int expect = Integer.MIN_VALUE;
        int expect_max = 0;
        int real_max = 0;
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        int[] counter = new int[L + 1];
        int[] max_counter = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                if (counter[j] == 0) {
                    counter[j] = i;
                }
            }
            if (expect < end - start) {
                expect = end - start;
                expect_max = i;
            }
        }
        for (int i = 1; i <= L; i++) {
            if (counter[i] == 0)
                continue;
            max_counter[counter[i]]++;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= N; i++) {
            if (ans < max_counter[i]) {
                ans = max_counter[i];
                real_max = i;
            }
        }
        System.out.println(expect_max);
        System.out.println(real_max);
    }
}
