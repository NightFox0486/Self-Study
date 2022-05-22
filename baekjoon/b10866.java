package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b10866 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Deque<Integer> queue = new LinkedList<>();
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      String oppr = st.nextToken();
      if(oppr.equals("push_front")){
        queue.addFirst(Integer.parseInt(st.nextToken()));
      }else if(oppr.equals("push_back")){
        queue.addLast(Integer.parseInt(st.nextToken()));
      }else if(oppr.equals("pop_front")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.pollFirst()+"\n");
        }
      }else if(oppr.equals("pop_back")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.pollLast()+"\n");
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
          sb.append(""+queue.peekFirst()+"\n");
        }
      }else if(oppr.equals("back")){
        if(queue.isEmpty()){
          sb.append("-1\n");
        }else{
          sb.append(""+queue.peekLast()+"\n");
        }
      }
    }
    System.out.println(sb);
  }
}
