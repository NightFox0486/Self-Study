package python.k1;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = "";
        String temp1 = "";
        String temp2 = "";
        char lastword = ' ';
        new_id = new_id.toLowerCase(); // 1.소문자로 치환
        char[] arr = new_id.toCharArray();
        for (int i = 0; i < new_id.length(); i++) {
            if (!((arr[i] >= 'a' && arr[i] <= 'z') || arr[i] == '-' || arr[i] == '_' || arr[i] == '.'
                    || (arr[i] >= '0' && arr[i] <= '9'))) // 2.허용된 범위 이외의 문자 제거
                arr[i] = ' ';

            if (arr[i] == ' ')
                continue;
            temp += Character.toString(arr[i]);
        }
        arr = temp.toCharArray();

        for (int i = 0; i < temp.length(); i++) {
            if (i != temp.length() - 1 && arr[i] == '.' && arr[i + 1] == '.') // 3.연속된 .제거
                arr[i] = ' ';

            if (arr[i] == ' ')
                continue;
            temp1 += Character.toString(arr[i]);
        }
        arr = temp1.toCharArray();
        for (int i = 0; i < temp1.length(); i++) {
            if (arr[0] == '.') // 4.처음과 끝 . 제거
                arr[0] = ' ';
            if (arr[temp1.length() - 1] == '.')
                arr[temp1.length() - 1] = ' ';
            if (arr[i] == ' ')
                continue;
            temp2 += Character.toString(arr[i]);
        }
        if (temp2 == "") // 5단계
            temp2 += 'a';
        arr = temp2.toCharArray();
        for (int i = 0; i < temp2.length(); i++) {
            if (i > 14) { // 6.자릿수 제한
                break;
            }
            if (i == 14) // 6단계
                if (arr[i] == '.')
                    arr[i] = ' ';

            if (arr[i] == ' ')
                continue;
            answer += Character.toString(arr[i]);
        }
        while (answer.length() < 3) {
            lastword = answer.charAt(answer.length() - 1);
            answer += Character.toString(lastword);
        }
        System.out.println(answer);
        return answer;
    }
}