package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11811 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] input = new int[N][N];
    int[] ans = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        input[i][j] = Integer.parseInt(st.nextToken());
        if(i!=j)
          ans[i] |= input[i][j];
      }
    }
    for (int i = 0; i < N; i++) {
      System.out.print(ans[i]+" ");
    }
  }
}
