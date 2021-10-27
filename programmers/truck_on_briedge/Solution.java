package truck_on_briedge;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridege = new LinkedList<Integer>();
        int current_weight = 0;
        for (int i = 0; i < truck_weights[i]; i++) {
            if (current_weight < weight) {
                current_weight += truck_weights[i];
                bridege.add(truck_weights[i]);
            }
        }

        return answer;
    }
}

// 한트럭당 무조건 breidge_length 만큼 시간 소비
// weight 여유가 있으면 다음 시간에 바로 다음트럭 출발
// weight가 허용하는한 최대 동시 진행수는 breidge_length 만큼
// 단위시간이랑 트럭번호랑 독립적으로 시행
