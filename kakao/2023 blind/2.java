public class Solution {
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
      long answer = -1;
      int current_cap;
      int total_time = 0;
      while(true){
          boolean clear = true;
          int current_time = 0;
          current_cap = cap;
          for(int i = 0;i<deliveries.length; i++){
              System.out.println("idx : "+i+" deli : "+deliveries[i]+"/"+pickups[i]);
          }
          for(int i = 0;i<deliveries.length; i++){
              if(deliveries[i]!=0||pickups[i]!=0)
                  clear = false;
          }
          if(clear)
              break;
          for(int i = n-1 ;i>=0;i--){
              boolean visit = false;
              if(deliveries[i]!=0){
                  if(deliveries[i]>current_cap){
                      deliveries[i] -= current_cap;
                      current_cap = 0;
                  }else{
                      current_cap -= deliveries[i];
                      deliveries[i] = 0;
                  }
                  visit = true;
              }
              if(cap!=current_cap)
                  if(pickups[i]!=0){
                      if(pickups[i]>cap-current_cap){
                          pickups[i]-=cap-current_cap;
                          current_cap = cap;
                      }else{
                          current_cap += pickups[i];
                          pickups[i] = 0;
                      }
                      visit = true;
                  }
              
              if(visit){
                  if(current_time<i+1)
                      current_time = i+1;
              }
          }
          total_time+=current_time;
          System.out.println("totalTime : "+total_time);
      }
      return answer;
  }
} 2 {
  
}
