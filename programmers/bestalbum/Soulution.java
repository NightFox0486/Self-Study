package bestalbum;

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Song[] songs = new Song[genres.length];
        for (int i = 0; i < songs.length; i++) {
            songs[i] = new Song(genres[i], plays[i]);
        }
        HashMap<Integer, Song> hash = new HashMap<>();
        for (int i = 0; i < songs.length; i++) {
            hash.put(i, songs[i]);
        }
        ArrayList<Map.Entry<Integer, Song>> list = new ArrayList<>(hash.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Song>>() {

            @Override
            public int compare(Entry<Integer, Song> o1, Entry<Integer, Song> o2) {
                return o2.getValue().plays - o1.getValue().plays;
            }

        });
        Collections.sort(list, new Comparator<Map.Entry<Integer, Song>>() {

            @Override
            public int compare(Entry<Integer, Song> o1, Entry<Integer, Song> o2) {
                return o2.getValue().genre.compareTo(o1.getValue().genre);
            }

        });
        HashMap<String, Integer> hashgenre = new HashMap<>(); /////////// 장르 우선순위 설정 //////
        for (int i = 0; i < songs.length; i++) {
            if (hashgenre.containsKey(songs[i].genre)) {
                hashgenre.put(songs[i].genre, hashgenre.get(songs[i].genre) + songs[i].plays);
            } else {
                hashgenre.put(songs[i].genre, songs[i].plays);
            }
        }

        ArrayList<Map.Entry<String, Integer>> genrelist = new ArrayList<>(hashgenre.entrySet());
        Collections.sort(genrelist, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().intValue() - o1.getValue().intValue();
            }

        });//////////////////////////////////////////////////////////////////////////////////////
           // System.out.println(genrelist);
           // System.out.println(list);

        List<Integer> answerlist = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < genrelist.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (genrelist.get(i).getKey().equals(list.get(j).getValue().genre) && (cnt < 2)) {
                    answerlist.add(list.get(j).getKey().intValue());
                    cnt++;
                }
            }
            cnt = 0;
        }
        answer = new int[answerlist.size()];
        for (int i = 0; i < answerlist.size(); i++) {
            answer[i] = answerlist.get(i);
        }
        return answer;
    }

    class Song {
        public String genre;
        public int plays;

        Song(String genre, int plays) {
            this.genre = genre;
            this.plays = plays;
        }
    }
}
