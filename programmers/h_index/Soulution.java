package h_index;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] Int_citations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(Int_citations, Comparator.reverseOrder());
        answer = Finder(Int_citations);
        return answer;
    }

    private int Finder(Integer[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {
            if (i + 1 <= num[i]) {
                temp = i + 1;
            }
        }
        return temp;
    }
}