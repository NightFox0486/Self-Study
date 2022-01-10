package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int min = M;
        int[] min_idx = new int[3];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i)
                    continue;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j || arr[i] + arr[j] + arr[k] > M)
                        continue;
                    if (min > M - (arr[i] + arr[j] + arr[k])) {
                        min = M - (arr[i] + arr[j] + arr[k]);
                        min_idx[0] = i;
                        min_idx[1] = j;
                        min_idx[2] = k;
                    }
                }
            }
        }
        bw.write(Integer.toString(arr[min_idx[0]] + arr[min_idx[1]] + arr[min_idx[2]]));
        bw.flush();
        bw.close();
        bf.close();
    }
}
