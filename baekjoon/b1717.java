package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1717 {
  static int[] par;

  static int find(int n){
    if(par[n] == n){
      return n;
    }else{
      par[n] = find(par[n]);
      return par[n];
    }
  }

  static void union_(int a, int b){
    a = find(a);
    b = find(b);
    par[a] = b;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    par = new int[N+1];
    for(int i = 1 ; i<= N; i++){
      par[i] = i;
    }
    int M = Integer.parseInt(st.nextToken());
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      if(Integer.parseInt(st.nextToken())==0){
        union_(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
      }else{
        int a = find(Integer.parseInt(st.nextToken()));
        int b = find(Integer.parseInt(st.nextToken()));
        if(a==b){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
      }
    }
  }
}
