class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        numbers = quicksort(numbers, 0, numbers.length);
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[0] == 0) {
                return "0";
            }
            sbf.append(Integer.toString(numbers[i]));
        }
        answer = sbf.toString();
        return answer;
    }

    private int getNextNum(String num, int index) {
        char[] chr = num.toCharArray();
        int value;
        if (index < num.length()) {
            value = chr[index] + 48;
        } else {
            value = chr[num.length() - 1] + 48;
        }
        return value;
    }

    private boolean sortindcator(int num1, int num2, int index) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        int src1 = getNextNum(str1, index);
        int src2 = getNextNum(str2, index);
        if (src1 < src2)
            return true; ///// 앞의 숫자가 작음 자리 변경
        else if (src1 > src2) {
            return false; //////// 앞의 숫자가 큼
        } else {
            // 다음자리수 까지 분석
            if ((index >= str1.length()) && (index >= str2.length())) { // 둘다 마지막 자리수일경우;
                return true;
            }
            return sortindcator(num1, num2, ++index);
        }
    }

    private int[] sort(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1 + i; j < numbers.length; j++) {
                if (sortindcator1(numbers[i], numbers[j], 0)) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    private boolean sortindcator1(int num1, int num2, int index) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        int i = (str1 + str2).compareTo(str2 + str1);
        if (i < 0) {
            return true;
        } else {
            return false;
        }
    }

    private void quicksort(int[] numbers, int left, int right) {
        int pi = partition(left, right, numbers);
    }

    private int partition(int left, int right, int[] numbers) {
        int pi = (left + right) / 2;
        int pv = numbers[pi];
        for (int i = left; i < right; i++) {

        }
        return pi;
    }
}
