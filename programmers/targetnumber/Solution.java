package programmers.targetnumber;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        answer += substream(numbers, true, 0, sum, target) + substream(numbers, false, 0, sum, target);
        return answer;
    }

    private int substream(int[] numbers, boolean flag, int index, int sum, int target) {
        if (flag)
            sum += numbers[index];
        else
            sum -= numbers[index];
        if (index == numbers.length - 1) {
            if (sum == target)
                return 1;
            else
                return 0;
        }
        int temp = 0;
        index++;
        temp += substream(numbers, true, index, sum, target);
        temp += substream(numbers, false, index, sum, target);
        return temp;
    }
}