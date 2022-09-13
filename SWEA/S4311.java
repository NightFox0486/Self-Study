package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4311 {
  static int N;
  static int O;
  static int M;
  static int[] number;
  static boolean[] opper;
  static int find;
  static int minCnt;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      O = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      number = new int[N];
      opper = new boolean[4];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        number[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < O; i++) {
        int temp = Integer.parseInt(st.nextToken());
        if (O == 1) {
          if (temp == 5) {
            for (int j = 0; j < 4; j++) {
              opper[j] = true;
            }
          } else {
            opper[temp - 1] = true;
          }
        } else {
          opper[temp - 1] = true;
        }
      }
      find = Integer.parseInt(br.readLine());
      
      System.out.println("#" + t + " " + minCnt);
    }
  }
}
