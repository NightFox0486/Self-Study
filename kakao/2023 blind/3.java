class Solution {
  static int[] arr;
  static int max_plus = Integer.MIN_VALUE;
  static int max_cost = 0;
  public static void dfs(int cur, int length, int[][] users, int[] emoticons){
      if(cur==length){
          int plus = 0;
          int cost = 0;
          for(int i = 0; i<users.length;i++){
              int total = 0;
              for(int j = 0; j<length; j++){
                  if(users[i][0]<=arr[j]){
                      total+=emoticons[j]/100*(100-arr[j]);
                  }
              }
              if(total >= users[i][1]){
                  plus++;
              }else{
                  cost += total;
              }
          }
          // System.out.println(plus+":"+cost);
          if(max_plus<=plus){
              if(max_plus==plus){
                  if(max_cost<cost){
                      max_cost=cost;
                  }
              }else{
                  max_plus=plus;
                  max_cost=cost;
              }
          }
          return;
      }
      for(int i = 10; i <= 40; i+=10){
          arr[cur] = i;
          dfs(cur+1, length, users, emoticons);
      }
  }

  public int[] solution(int[][] users, int[] emoticons) {
      int[] answer = {};
      arr = new int[emoticons.length];
      dfs(0, emoticons.length, users, emoticons);
      answer = new int[2];
      answer[0] = max_plus;
      answer[1] = max_cost;
      return answer;
  }
}