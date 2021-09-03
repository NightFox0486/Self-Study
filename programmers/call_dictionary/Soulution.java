package call_dictionary;

import java.util.Arrays;
//import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        // HashMap<Integer, String> hash = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        // for (int i = 0; i < phone_book.length - 1; i++) {
        // for (int j = i + 1; j < phone_book.length; j++) {
        // if (phone_book[j].startsWith(phone_book[i])) {
        // return false;
        // }
        // }
        // }
        return answer;
    }
}