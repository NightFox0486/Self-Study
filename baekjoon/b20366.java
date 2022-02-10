package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b20366 {
    static int[] arr;
    static int[] output;
    static boolean[] selected;
    static int N;
    static int cnt = 0;

    static void recur(int cur, int start, int sum) {
        if (cur == 2) {
            output[cnt] = sum;
            cnt++;
            return;
        }
        for (int i = start; i < N; i++) {
            if (selected[i])
                continue;
            selected[i] = true;
            recur(cur + 1, i + 1, sum + arr[i]);
            selected[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        selected = new boolean[N];
        output = new int[(N * (N - 1)) / 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recur(0, 0, 0);
        Arrays.sort(output);
        int s = 0;
        int e = 2;
        int min = output[e] - output[s];
        while (e < ((N * (N - 1)) / 2) - 1) {
            s++;
            e++;
            if ((output[e] - output[s]) < min) {
                min = (output[e] - output[s]);
            }
        }
        System.out.println(min);
    }
}
