package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int s = 0;
        int e = N - 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int first = arr[s];
        int second = arr[e];
        while (s < e) {
            if (Math.abs(arr[s] + arr[e]) < Math.abs(first + second)) {
                first = arr[s];
                second = arr[e];
            }
            if (arr[s] + arr[e] < 0) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(first + " " + second);
    }
}
