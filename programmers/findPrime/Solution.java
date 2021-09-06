package findPrime;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] numchar = numbers.toCharArray();
        int[] numint = new int[numbers.length()];
        HashSet<Integer> numset = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            numint[i] = numchar[i] + 48;
        }

        searchAll(numchar, numset);
        System.out.println(numset);
        Iterator<Integer> itr = numset.iterator();
        while (itr.hasNext()) {
            if (isPrime(itr.next())) {
                answer++;
            }
        }

        return answer;
    }

    boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    void searchAll(char[] numchar, HashSet<Integer> numSet) {
        boolean[] flag = new boolean[numchar.length];
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < numchar.length; i++) {
            subroutine(numSet, sbr, flag, numchar, i + 1);
            // System.out.println();
        }
    }

    void subroutine(HashSet<Integer> numSet, StringBuilder sbr, boolean[] flag, char[] numchar, int length) {
        if (length > 0) {
            for (int j = 0; j < numchar.length; j++) {
                if (flag[j]) {
                    continue;
                } else {
                    flag[j] = true;
                    sbr.append(numchar[j]);
                    subroutine(numSet, sbr, flag, numchar, length - 1);
                    flag[j] = false;
                    if (length == 1) {
                        numSet.add(Integer.valueOf(sbr.toString()));
                        // System.out.print(sbr + "#");
                        sbr.delete(sbr.length() - 1, sbr.length());
                    }
                }
                if (length > 1)
                    sbr.delete(sbr.length() - 1, sbr.length());
            }
        }
    }
}
