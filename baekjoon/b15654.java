package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15654 {
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visited;
    public static int[] input;

    public static void recur(int cur) {
        if (cur == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;

        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true;
            arr[cur] = input[i];
            recur(cur + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        arr = new int[M];

        recur(0);
    }
}
