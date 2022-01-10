package baekjoon;

public class exam2 {
    public static void main(String[] args) {
        String inp_str = "UUUUU";
        int[] answer = solution(inp_str);
        System.out.println(answer);
    }

    static int[] solution(String inp_str) {
        int[] answer = {};
        int check_all = 0;
        boolean[] check_all_bool = { false, false, false, false, false };
        boolean[] cnt3 = { false, false, false, false };
        //////////////////////////////////////////////////////////////////////////////////////////// 1번
        if (inp_str.length() < 8 || inp_str.length() > 15) {
            check_all_bool[0] = true;
            check_all++;
        }
        //////////////////////////////////////////////////////////////////////////////////////////// 2번
        //////////////////////////////////////////////////////////////////////////////////////////// 밑
        //////////////////////////////////////////////////////////////////////////////////////////// 3번
        //////////////////////////////////////////////////////////////////////////////////////////// 작업
        char[] ch = inp_str.toCharArray();
        for (int i = 0; i < inp_str.length(); i++) {
            if (ch[i] < 'A' || ch[i] > 'Z') {
                if (ch[i] < 'a' || ch[i] > 'z') {
                    if (ch[i] < '0' || ch[i] > '9') {
                        if (ch[i] != '~' && ch[i] != '!' && ch[i] != '@' && ch[i] != '#' && ch[i] != '$' && ch[i] != '%'
                                && ch[i] != '^' && ch[i] != '&' && ch[i] != '*') {
                            check_all_bool[1] = true;
                            check_all++;
                        } else {
                            cnt3[3] = true;
                        }
                    } else {
                        cnt3[2] = true;
                    }
                } else {
                    cnt3[1] = true;
                }
            } else {
                cnt3[0] = true;
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////// 3번
        int sum3 = 0;
        for (int i = 0; i < 4; i++) {
            if (cnt3[i]) {
                sum3 += 1;
            }
        }
        if (sum3 < 3) {
            check_all_bool[2] = true;
            check_all++;
        }
        /////////////////////////////////////////////////////////////////////////////////////////// 4번
        char temp = ch[0];
        int cnt4 = 1;
        for (int i = 1; i < inp_str.length(); i++) {
            if (temp == ch[i]) {
                cnt4++;
                temp = ch[i];
            }
        }
        if (cnt4 > 3) {
            check_all_bool[3] = true;
            check_all++;
        }
        /////////////////////////////////////////////////////////////////////////////////////////// 5번
        boolean check5 = false;
        int[] cnt5 = new int[inp_str.length()];
        for (int i = 0; i < inp_str.length(); i++) {
            cnt5[i] = 0;
        }
        for (int i = 0; i < inp_str.length() - 1; i++) {
            for (int j = 1; j < inp_str.length(); j++) {
                if (ch[i] == ch[j]) {
                    cnt5[i]++;
                }
            }
        }
        for (int i = 0; i < inp_str.length(); i++) {
            if (cnt5[i] > 3) {
                check5 = true;
            }
        }
        if (check5) {
            check_all_bool[4] = true;
            check_all++;
        }
        answer = new int[check_all];
        int answer_num = 0;
        for (int i = 0; i < 5; i++) {
            if (check_all == 0) {
                answer[answer_num] = i;
            }
            if (check_all_bool[i]) {
                answer[answer_num] = i + 1;
                answer_num++;
            }
        }
        return answer;
    }

}
