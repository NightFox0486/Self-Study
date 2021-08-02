//import java.util.StringTokenizer;

public class exam {
    public static void main(String[] args) {
        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = { "JAVA", "JAVASCRIPT" };
        int[] preference = { 7, 5 };
        String answer = solution(table, languages, preference);
        System.out.println(answer);
    }

    private static String solution(String[] table, String[] languages, int[] preference) {
        return null;
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
