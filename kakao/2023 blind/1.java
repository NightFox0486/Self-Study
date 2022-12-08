import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int t_year = Integer.parseInt(today.substring(0,4));
        int t_month = Integer.parseInt(today.substring(5,7));
        int t_day = Integer.parseInt(today.substring(8,10));

        // for (int i = 0; i<terms.length; i++){
        //     System.out.println(terms[i]);
        // }
        for (int i = 0; i< privacies.length; i++){
            privacies[i].charAt(11); // 약관 종류
            int c_year = Integer.parseInt(privacies[i].substring(0,4));
            int c_month = Integer.parseInt(privacies[i].substring(5,7));
            int c_day = Integer.parseInt(privacies[i].substring(8,10));
            for(int j = 0; j<terms.length;j++){
                if(privacies[i].charAt(11)==terms[j].charAt(0)){
                    int term = Integer.parseInt(terms[j].substring(2,terms[j].length()));
                    int terms_year = term/12;
                    int terms_month = term%12;
                    c_year += terms_year;
                    c_month+=terms_month;
                    if(c_month>12){
                        System.out.println(c_month);
                        c_year+=c_month/12;
                        c_month%=12;
                        
                    }
                    c_day--;
                    if(c_day==0){
                        c_day=28;
                        c_month--;
                        if(c_month==0){
                            c_month=12;
                            c_year--;
                        }
                    }
                }
            }
            if(t_year>c_year){
                list.add(i+1);
            }else if(t_year==c_year){
                if(t_month>c_month){
                    list.add(i+1);
                }else if(t_month==c_month){
                    if(t_day>c_day){
                        list.add(i+1);
                    }
                }
            }
            // System.out.println(c_year+":"+c_month+":"+c_day);
        }
        answer = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}