package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arrA = new int[A];
            int[] arrB = new int[B];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            int start = 0;
            int end = 0;
            Arrays.sort(arrA);
            Arrays.sort(arrB);
            while (start < A) {
                if (end > B - 1) {
                    start++;
                    if (start > A - 1)
                        break;
                    end = 0;
                }
                if (arrA[start] > arrB[end]) {
                    cnt++;
                    end++;
                } else if (arrA[start] < arrB[end]) {
                    end = 0;
                    start++;
                } else {
                    end = 0;
                    start++;
                }
            }
            System.out.println(cnt);
        }
    }
}
