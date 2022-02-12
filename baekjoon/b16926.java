package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16926 {
    static int[][] arrNM;
    static int[][] arrMN;
    static int arrState = 0;
    static int N;
    static int M;

    static void Rotator() {
        if (arrState == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                }
            }
            arrState = 1;
        } else {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                }
            }
            arrState = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        arrNM = new int[N][M];
        arrMN = new int[M][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arrNM[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            Rotator();
        }
        ;

        if (arrState == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(arrNM[i][j] + " ");
                }
                sb.append("\n");
            }
        } else {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arrMN[i][j] + " ");
                }
                sb.append("\n");
            }
        }
    }
}
