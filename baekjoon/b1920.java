package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1920 {
  static List<Integer> input = new ArrayList<>();

  static boolean BinarySearch(int n){
    int left=0;
    int right=input.size()-1;
    if(input.get(left)>n||input.get(right)<n)
      return false;
    while(left<=right){
      int mid=(left+right)/2;
      if(n>input.get(mid)){
        left=mid+1;
      }else if(n<input.get(mid)){
        right=mid-1;
      }else{
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++){
      input.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(input);
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++){
      
      if(BinarySearch(Integer.parseInt(st.nextToken())))
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}
