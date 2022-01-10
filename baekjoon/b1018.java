package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        int min = 64;
        int temp = min;
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                temp = finder(i, j, arr, min);
                if (min > temp)
                    min = temp;
            }
        }
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        bf.close();
    }

    public static int finder(int x, int y, char[][] arr, int min) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 시작이 흰색인 부분 서치
                if ((i + j) % 2 == 0) {
                    if (arr[i][j] == 'B')
                        cnt1++;
                } else {
                    if (arr[i][j] == 'W')
                        cnt1++;
                }
                // 시작이 흑색인 부분 서치
                if ((i + j) % 2 == 0) {
                    if (arr[i][j] == 'W')
                        cnt2++;
                } else {
                    if (arr[i][j] == 'B')
                        cnt2++;
                }
            }
        }
        if (cnt1 < min)
            min = cnt1;
        if (cnt2 < min)
            min = cnt2;
        return min;
    }
}