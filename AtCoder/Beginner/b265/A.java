package AtCoder.Beginner.b265;

import java.util.Scanner;
import java.util.StringTokenizer;

// 사과 1개 x
// 사과 3개 y

// N개 사려면 얼마 필요?

public class A {
  public static void main(String[] args) {
    int answer = 0;
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int Z = Integer.parseInt(st.nextToken());

    if(X * 3 < Y){
      answer = X * Z;
    }else{
      answer = Z / 3 * Y;
      answer += Z % 3 * X;
    }

    System.out.println(answer);
  }
}
