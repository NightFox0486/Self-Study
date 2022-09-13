package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b2164 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Deque <Integer> deque = new LinkedList<>();
    for(int i = 0; i < N; i++){
      deque.addLast(i+1);
    }
    while(deque.size() !=1){
      deque.pollFirst();
      if(deque.size()==1)
        break;
      int temp = deque.pollFirst();
      deque.addLast(temp);
    }
    System.out.println(deque.poll());
  }
}
