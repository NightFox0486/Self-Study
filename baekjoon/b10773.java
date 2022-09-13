package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class b10773 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int sum = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < N; i++) {
      int temp = sc.nextInt();
      if(temp!=0){
        stack.add(temp);
      }else{
        if(!stack.isEmpty())
          stack.pop();
      }
    }
    while(!stack.isEmpty()){
      sum+=stack.pop();
    }
    System.out.println(sum);
  }
}
