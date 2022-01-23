package Range;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class case2 {
    public static int N;
    public static int M;
    public static int[] arr = new int[110];
    static boolean[] visited = new boolean[110];

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
            if (visited[i]) {
                continue; // 사용중 이라면 건너뜀
            }
            arr[cur] = i;
            visited[i] = true; // 사용중인지
            recur(cur + 1);
            visited[i] = false; // 출력이 되었다면 해제

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