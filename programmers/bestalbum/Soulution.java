package bestalbum;

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
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
        System.out.println(list);
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
