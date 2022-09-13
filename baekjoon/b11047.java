package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11047 {
  static int N;
  static int K;
  static int[] coins;
  //static int[] arr = new int[99999];

  // public static boolean recur(int cur, int n, int sum) {
  //   boolean ans = false;
  //   if(sum>K)
  //     return false;
  //   if (cur == n) {
  //     if(sum == K){
  //       return true;
  //     }
  //     return false;
  //   }
  //   for (int i = 0; i < N; i++) {
  //     ans = recur(cur+1, n, sum + coins[i]);
  //     if(ans)
  //       break;
  //   }
  //   return ans;
  // }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
    int cnt=0;
    int coinIndex = N-1;
    while(true){
      if(K==0)
        break;
      if(K>=coins[coinIndex]){
        K-=coins[coinIndex];
        cnt++;
      }else{
        coinIndex--;
      }
    }
    // while(true){
    //   if(recur(0, cnt, 0)){
    //     break;
    //   }
    //   cnt++;
    // }
    System.out.println(cnt);
  }
}