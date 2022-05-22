package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14231 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] input = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      input[i]=Integer.parseInt(st.nextToken());
    }
    int temp = input[0];
    int score = 0;
    for(int i=1; i<N; i++){
      score+=temp*input[i];
      temp=temp+input[i];
    }
    System.out.println(score);
  }
}