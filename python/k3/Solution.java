package python.k3;

import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Person[] ps = new Person[info.length];
        Request[] rq = new Request[query.length];
        StringTokenizer st;
        for (int i = 0; i < info.length; i++) {
            st = new StringTokenizer(info[i]);
            ps[i] = new Person();
            ps[i].language = st.nextToken();
            ps[i].job = st.nextToken();
            ps[i].career = st.nextToken();
            ps[i].food = st.nextToken();
            ps[i].score = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < query.length; i++) {
            st = new StringTokenizer(query[i]);
            rq[i] = new Request();
            rq[i].language = st.nextToken();
            st.nextToken();
            rq[i].job = st.nextToken();
            st.nextToken();
            rq[i].career = st.nextToken();
            st.nextToken();
            rq[i].food = st.nextToken();
            rq[i].score = Integer.parseInt(st.nextToken());
            answer[i] = 0;
        }
        for (int i = 0; i < query.length; i++) {
            for (int j = 0; j < info.length; j++) {
                if (ps[j].language.equals(rq[i].language) || rq[i].language.equals("-"))
                    if (ps[j].job.equals(rq[i].job) || rq[i].job.equals("-"))
                        if (ps[j].career.equals(rq[i].career) || rq[i].career.equals("-"))
                            if (ps[j].food.equals(rq[i].food) || rq[i].food.equals("-"))
                                if (ps[j].score >= rq[i].score)
                                    answer[i]++;
            }
        }
        return answer;
    }

    class Person {
        String language = "";
        String job = "";
        String career = "";
        String food = "";
        int score = 0;
    }

    class Request {
        String language = "";
        String job = "";
        String career = "";
        String food = "";
        int score = 0;
    }
}