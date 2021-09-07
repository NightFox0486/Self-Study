package targetnumber;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) { ///////// -의 개수별로 탐색 : i는 -개수
            for (int j = 0; j < i; j++) {
                sum += (-1) * j * numbers[i];
            }
        }
        return answer;
    }
}

// 2^n개의 경우의수
// 12345
// -1-2-3-4-5

// - 0 1
// 12345

// -1 n
// -12345
// 1-2345
// 12-345
// 123-45
// 1234-5

// -2 2n
// -1-2345
// -12-345
// -123-45
// -1234-5

// 1-2-345
// 1-23-45
// 1-234-5

// 12-3-45
// 12-34-5

// 123-4-5