package truck_on_briedge;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0;
        int i = 0;
        int counter = 0;
        int start = 0;
        int end = 0;
        boolean flag = true;
        int[] cnt = new int[truck_weights.length];
        while (flag) {
            for (int j = start; j < end; j++) {
                cnt[j]++;
                if (cnt[j] == bridge_length) {
                    current_weight -= truck_weights[j];
                    start = j + 1;
                    if (start == truck_weights.length) {
                        flag = false;
                        break;
                    }
                }
            }
            if (i < truck_weights.length && current_weight + truck_weights[i] <= weight) {
                current_weight += truck_weights[i];
                i++;
                end = i;
            }
            counter++;
        }
        answer = counter;

        return answer;
    }
}

/*
 * abstract 현재 트럭과 뒤에 트럭들의 합이 weight보다 작으면 weight안넘을때 까지만 동시 진행 간격당 시간 1추가
 */