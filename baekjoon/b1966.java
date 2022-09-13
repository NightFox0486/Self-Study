package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int findValue = -1;
      int cnt = 1;
      Integer[] input = new Integer[N];
      Queue<int[]> queue = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        input[i] = Integer.parseInt(st.nextToken());
        if(i==M){
          findValue = input[i];
        }
        queue.add(new int[]{i,input[i]});
      }
      Arrays.sort(input,(o1,o2)->o2-o1);
      int i = 0;
      while(true){
        if(queue.peek()[0]==M&&queue.peek()[1]==findValue&&input[i]==queue.peek()[1]){
          break;
        }
        if(queue.peek()[1]==input[i]){
          queue.poll();
          cnt++;
          i++;
        }else{
          int[] temp = queue.poll();
          queue.add(temp);
        }
      }
      System.out.println(cnt);
    }
  }
}
