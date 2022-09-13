package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.test;

public class N3 {
  static int N;
  static int M;
  static int maxHand;
  static List<Integer> maxList;
  static int[] cntArray;
  static Queue<Integer> queue;

  static void setMaxList(){
    maxHand = 0;
    maxList = new LinkedList<>();
    for(int i = 1 ;i <= M;i++){
      maxHand = Math.max(maxHand, cntArray[i]);
    }
    for (int i = 1; i <= M; i++) {
      if(cntArray[i] == maxHand){
        maxList.add(i);
      }
    }
  }
  static void print(){
    Iterator<Integer> iter = queue.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next()+" ");
    }
    System.out.println();
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      cntArray = new int[M+1];
      queue = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()){
        int temp = Integer.parseInt(st.nextToken());
        cntArray[temp]++;
        queue.add(temp);
      }
      setMaxList();
      int ans = 0;
      int cnt = queue.size();
      boolean removeCheck = false;
      while(true){
        if(cnt == 0){
          cnt = queue.size();
          setMaxList();
          removeCheck = false;
        }
        //print();
        if(queue.size()==1){
          ans = queue.poll();
          break;
        }
        int temp = queue.poll();
        if(!removeCheck&&maxList.contains(temp)){
          cntArray[temp]--;
          cnt--;
          removeCheck = true;
          N--;
          if(N==0){
            ans = temp;
            break;
          }
          continue;
        }
        N--;
        if(N==0){
          ans = temp;
          break;
        }
        queue.add(temp);
        cnt--;
      }
      System.out.println("#"+t+" "+ans);
    }
  }
}
