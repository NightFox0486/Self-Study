package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b10845 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Deque<Integer> queue = new LinkedList<>();
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      String oppr = st.nextToken();
      if(oppr.equals("push")){
        queue.add(Integer.parseInt(st.nextToken()));
      }else if(oppr.equals("pop")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.poll()+"\n");
        }
      }else if(oppr.equals("size")){
        sb.append(""+queue.size()+"\n");
      }else if(oppr.equals("empty")){
        if(queue.isEmpty()){
          sb.append("1\n");
        }else{
          sb.append("0\n");
        }
      }else if(oppr.equals("front")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.getFirst()+"\n");
        }
      }else if(oppr.equals("back")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.getLast()+"\n");
        }
      }
    }
    System.out.println(sb);
  }
}
