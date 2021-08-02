//import java.util.StringTokenizer;

public class exam {
    public static void main(String[] args) {
        System.out.println("2222");
        solution(1, 2, 3);
    }

    static String solution(int day, int width, int blocks) {
        String answer = "dd";
        System.out.println("sefsef");
        return answer;
    }

    // static String solution(String[] table, String[] languages, int[] preference)
    // {
    // String answer = "";
    // StringTokenizer st;
    // String[] sampletable = new String[5];
    // int[] sumation = new int[5];
    // String test = "";
    // int max = 0;
    // int selectcategorynum = 0;

    // for (int i = 0; i < 5; i++) { // 각 계층별 검색;
    // st = new StringTokenizer(table[i]);
    // sampletable[i] = st.nextToken();
    // for (int j = 0; j < 5; j++) {
    // test = st.nextToken();
    // for (int k = 0; k < languages.length; k++) { //
    // if (test.equals(languages[k])) {
    // sumation[i] += (5 - j) * preference[k]; // 매칭된 값을 저장;
    // }
    // }

    // }
    // }
    // for (int i = 0; i < 5; i++) {
    // if (max <= sumation[i]) {
    // if (max == sumation[i]) {
    // char[] ch1 = sampletable[selectcategorynum].toCharArray();
    // char[] ch2 = sampletable[i].toCharArray();
    // if (ch1[0] > ch2[0]) {
    // selectcategorynum = i;
    // }
    // } else {
    // selectcategorynum = i;
    // }
    // max = sumation[i];
    // }
    // }
    // answer = sampletable[selectcategorynum];
    // return answer;
    // }
}
