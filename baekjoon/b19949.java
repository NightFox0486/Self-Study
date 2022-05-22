package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b19949 {
  static int N = 10;
  static int[] input = new int[N];
  static int[] arr = new int[N];
  static int cnt = 0;

  static void recur(int cur){
      if(cur==N){
        int sum = 0;
        for( int i = 0; i < N; i++){
          if(input[i]==arr[i])
            sum++;
          if(i>1){
            if(arr[i]==arr[i-1]&&arr[i]==arr[i-2])
              return;
          }
        }
        if(sum>=5){
          cnt++;
        }
        return;
      }
      for(int i=1 ; i<=5;i++){
        arr[cur] = i;
        recur(cur+1);
      }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    recur(0);
    System.out.println(cnt);
  }
}
