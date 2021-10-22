package truck_on_briedge;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0;
        for (int i = 0; i < truck_weights.length;) {
            if (current_weight < weight) {
                current_weight += truck_weights[i];
            } else {
                answer += 1;
            }
            answer += bridge_length - 1;
        }

        return answer;
    }
}

/*
 * abstract 현재 트럭과 뒤에 트럭들의 합이 weight보다 작으면 weight안넘을때 까지만 동시 진행 간격당 시간 1추가
 */