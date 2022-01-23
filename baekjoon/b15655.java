package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15655 {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] input;
    public static boolean[] visited;

    public static void recur(int cur, int start) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            arr[cur] = input[i];
            recur(cur + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        input = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        recur(0, 0);
    }

}
