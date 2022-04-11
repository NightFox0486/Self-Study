package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4446 {
    static boolean isCapital(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }

    static boolean isVowel(char ch) {
        char temp = isCapital(ch) ? (char) ((int) ch - 'A' + 'a') : ch;
        for (char c : vowels) {
            if (c == temp)
                return true;
        }
        return false;
    }

    static char changeVowel(char ch) {
        char temp = isCapital(ch) ? (char) ((int) ch - 'A' + 'a') : ch;
        int cnt = 0;
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == temp)
                cnt = i;
        }
        cnt += 3;
        if (cnt >= vowels.length)
            cnt %= vowels.length;
        return vowels[cnt];
    }

    static char changeConsonants(char ch) {
        char temp = isCapital(ch) ? (char) ((int) ch - 'A' + 'a') : ch;
        int cnt = 0;
        for (int i = 0; i < consonants.length; i++) {
            if (consonants[i] == temp)
                cnt = i;
        }
        cnt += 10;
        if (cnt >= consonants.length)
            cnt %= consonants.length;
        return consonants[cnt];
    }

    static char[] vowels = { 'u', 'o', 'e', 'y', 'i', 'a' };
    static char[] consonants = { 'f', 'm', 'l', 'r', 's', 't', 'q', 'j', 'v', 'p', 'g', 'w', 'c', 'd', 'h', 'n', 'z',
            'x', 'k', 'b' };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] < 'A' || chs[i] > 'z')
                    continue;
                boolean isCap = isCapital(chs[i]);
                if (isVowel(chs[i])) {
                    chs[i] = changeVowel(chs[i]);
                    if (isCap)
                        chs[i] += 'A' - 'a';
                } else {
                    chs[i] = changeConsonants(chs[i]);
                    if (isCap)
                        chs[i] += 'A' - 'a';
                }
            }
            System.out.println(chs);
        }
    }
}