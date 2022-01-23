package Range;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class case1 {
    public static int N;
    public static int M;
    public static int[] arr = new int[110];

    public static void recur(int cur) {
        if (cur == N) {
            System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < M; i++) {
            arr[cur] = i;
            recur(cur + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        recur(0);

    }
}