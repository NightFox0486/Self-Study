package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemB {
    static int N;
    static long[] arr;

    static int getMax() {
        long max = -1;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new long[N];
            String output = "";
            long max = -1;
            int index = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max <= arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
            long submax = -1;
            int subindex = -1;
            for (int i = 0; i < N; i++) {
                if (i == index) {
                    continue;
                }
                if (submax <= arr[i]) {
                    submax = arr[i];
                    subindex = i;
                }
            }
            if (subindex == -1 || index == subindex || Math.abs(arr[index] - arr[subindex]) > 1) {
                output = "NO";
            } else {
                output = "YES";
            }
            if (arr.length == 1 && arr[0] == 1) {
                output = "YES";
            }
            System.out.println(output);
        }
    }
}
