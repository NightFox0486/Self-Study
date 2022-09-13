package AtCoder.Beginner.b265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동굴은 N 개의 방이 행으로 나와 있고 입구는 1, 2, .. N
// 처음에 1번이고 시간 제한은  T
// 다음방 넘어갈때 Ai 만큼 시간 소모
// Xi 가 보너스 룸  M 개의 보너스 룸 보너스룸 오면 Y 만큼 증가
// N에 도달 가능 ?

public class B {
  public static void main(String[] args) throws IOException {
    String answer = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int totalTime = 0;
    for (int i = 0; i < N-1; i++) {
      totalTime += Integer.parseInt(st.nextToken());
    }

    int bonusTime = 0;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      bonusTime += Integer.parseInt(st.nextToken());
    }

    if(totalTime <= T + bonusTime){
      answer = "Yes";
    }else{
      answer = "No";
    }

    System.out.println(totalTime);
    System.out.println(answer);

  }
}
