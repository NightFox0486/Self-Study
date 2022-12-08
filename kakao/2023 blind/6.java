import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

class Solution {
    static int[] dy = {1,0,0,-1};
    static int[] dx = {0,-1,1,0};
    static char[] dir = {'d', 'l', 'r', 'u'};
    static int[][] map;
    static int N;
    static int M;
    static Point S;
    static Point E;
    static int cost;
    static List<String> answerList;
    static String answer = "";

    static class Point{
        int x;
        int y;
        int cost;
        StringBuilder sb;
        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.cost = 0;
            this.sb = new StringBuilder();
        }
    }

    public static void solve2(){
        StringBuilder sb = new StringBuilder();
        if(S.x<E.x){ // 아래
            for(int i = 0; i<E.x-S.x; i++){
                sb.append("d");
            }
            if(S.y>E.y){ // 왼쪽
                for(int i = 0; i<S.y-E.y; i++){
                    sb.append("l");
                }
            }else{ // 오른쪽
                for(int i = 0; i<E.y-S.y; i++){
                    sb.append("r");
                }
            }
        }else{ // 위쪽
            if(S.y>E.y){ // 왼쪽
                for(int i = 0; i<S.y-E.y; i++){
                    sb.append("l");
                }
                }else{ // 오른쪽
                    for(int i = 0; i<E.y-S.y; i++){
                        sb.append("r");
                    }
                }
            for(int i = 0; i<S.x-E.x; i++){
                sb.append("u");
            }
        }
        if(sb.length()<cost){
            if((cost-sb.length())%2==0){
                int remain = (cost-sb.length())/2;
                if(E.x<N-1){
                    for(int i=0; i<remain; i++){
                        sb.append("du");
                    }
                }
                else if(E.y>0){
                    for(int i=0; i<remain; i++){
                        sb.append("lr");
                    }
                }else if(E.y<M-1){
                    for(int i=0; i<remain; i++){
                        sb.append("rl");
                    }
                }else{
                    for(int i=0; i<remain; i++){
                        sb.append("ud");
                    }
                }
            }else{
                answer = "impossible";
                return;
            }
        }else if(sb.length()>cost){
            answer = "impossible";
            return;
        }
        answer = sb.toString();
    }

    // public static int solve1(int cur, Point current){
    //     if(cur==cost){
    //         if(current.x == E.x && current.y == E.y){
    //             String str_temp = current.sb.toString();
    //             System.out.println(str_temp);
    //             answer = str_temp;
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
    //     for(int i = 0; i<4; i++){
    //         int nx = current.x+dy[i];
    //         int ny = current.y+dx[i];
    //         if(nx>N-1 || ny>M-1 || nx<0 || ny<0)
    //             continue;
    //         Point temp = new Point(nx, ny);
    //         temp.cost = current.cost+1;
    //         temp.sb.append(current.sb);
    //         temp.sb.append(dir[i]);
    //         if(solve1(cur+1, temp)==1)
    //             return 1;
    //     }
    //     return 0;
    // }

    // public static void solve(){
    //     Queue<Point> queue = new LinkedList<>();
    //     S.cost = 0;
    //     queue.add(S);
    //     while(true){
    //         if(queue.isEmpty())
    //             break;
    //         Point current = queue.poll();
    //         if(current.cost==cost){
    //             // System.out.println(current.x+":"+current.y);
    //             if(current.x == E.x && current.y == E.y){
    //                 // System.out.println(current.sb+":"+current.cost);
    //                 String str_temp = current.sb.toString();
    //                 answer = str_temp;
    //                 // answerList.add(str_temp);
    //                 break;
    //                 //end
    //             }
    //         }else if(current.cost>cost){
    //             continue;
    //         }
    //         for(int i = 0; i<4; i++){
    //             int nx = current.x+dy[i];
    //             int ny = current.y+dx[i];
    //             if(nx>N-1 || ny>M-1 || nx<0 || ny<0)
    //                 continue;
    //             Point temp = new Point(nx, ny);
    //             temp.cost = current.cost+1;
    //             temp.sb.append(current.sb);
    //             temp.sb.append(dir[i]);
    //             queue.add(temp);
    //         }
    //     }
    // }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // answerList = new ArrayList<>();
        N = n;
        M = m;
        cost = k;
        map = new int[n][m];
        S = new Point(x-1, y-1);
        E = new Point(r-1, c-1);

        solve2();
        // if(answerList.isEmpty()){
        //     answer = "impossible";
        // }else{
        //     for(int i = 0; i<answerList.size();i++){
        //         Collections.sort(answerList);
        //         // System.out.println(answerList.get(i));
        //     }
        //     answer = answerList.get(0);
        // }
        // if(answer.equals("")){
        //     answer="impossible";
        // }
        return answer;
    }
}