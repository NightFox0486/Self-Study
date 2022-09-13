package SWEA.SSAFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// N개의 절반중 앞부분은 왼쪽 뒷부분은 오른쪽
// 사용자가 섞이기 시작하는 지점 설정 가능
// 다이얼은 0~N-1
// N/2-1 이하는 오른쪽 부터 쌓이는 개수 0이면 없음 남은 개수확인해서 넣기
// N/2 이상은 왼쪽 부터 쌓이는 개수 N-1 부터 하나씩

class Shuffle_O_Matic{
  public static int[] inputCards;

  public static boolean asceChecker(int[] cards){
    for(int i = 1; i < cards.length-1; i++){
      if(cards[i] > cards[i + 1]){
        return false;
      }
    }
    return true;
  }

  public static boolean descChecker(int[] cards){
    for(int i = 1; i < cards.length-1; i++){
      if(cards[i] < cards[i + 1]){
        return false;
      }
    }
    return true;
  }

  public static int[] shuffler(int x, int[] cards){

    // x = 0 이면 그냥 순서대로
    Stack<Integer> leftCards = new Stack<>();
    Stack<Integer> rightCards = new Stack<>();
    Deque<Integer> returnCards = new LinkedList<>();
    int[] result = new int[cards.length];
    for(int i = 0; i < cards.length/2; i++){
      //if(i<cards.length/2){
        leftCards.push(cards[i]);
      //}else{
        rightCards.push(cards[cards.length - 1 - i]);
      //}
    }
    if(x < cards.length/2){ // x 가 절반 이하
      for(int i = 0; i < cards.length/2; i++){
        if(x > 0){
          returnCards.addFirst(rightCards.pop());
          returnCards.addLast(leftCards.pop());
          x--;
        }else{
          returnCards.addFirst(leftCards.pop());
          returnCards.addLast(rightCards.pop());
        }
      }
    }else{
      for(int i = 0; i < cards.length/2; i++){
        if(x < cards.length-1){
          returnCards.addFirst(leftCards.pop());
          returnCards.addLast(rightCards.pop());
          x++;
        }else{
          returnCards.addFirst(rightCards.pop());
          returnCards.addLast(leftCards.pop());
        }
      }
    }
    for(int i = 0; i < cards.length; i++){
      result[i] = returnCards.removeFirst();
    }
    return result;
  }

  public static class DeckDepth{
    int[] deck;
    int depth;
    DeckDepth(int[] deck, int depth){
      this.deck = deck;
      this.depth = depth;
    }
  }

  public static int bfs(){
    Queue<DeckDepth> queue = new LinkedList<>();
    queue.add(new DeckDepth(inputCards, 0));
    while(!queue.isEmpty()){
      DeckDepth current = queue.poll();
      if(current.depth > 5)
        return -1;
      for(int i = 0; i < inputCards.length; i++){
        if(asceChecker(current.deck)){
          return current.depth;
        }
        if(descChecker(current.deck)){
          return current.depth;
        }
        int[] temp = shuffler(i, current.deck);
        queue.add(new DeckDepth(temp, current.depth + 1));
      }
    }
    return -1;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(bf.readLine());
    for(int t=1; t<=T; t++){
      int N = Integer.parseInt(bf.readLine());
      inputCards = new int[N];
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for(int i=0; i<N; i++){
        inputCards[i] = Integer.parseInt(st.nextToken());
      }
      int answer = bfs();

      System.out.println("#" + t + " " + answer);
    }
  }
}