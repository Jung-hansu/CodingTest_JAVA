import java.util.*;

class Solution{
    public String[] solution(String[] players, String[] callings){
        Map<String, Integer> rankMap = new HashMap<>();
        Map<Integer, String> playerMap = new HashMap<>();
        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++){
            rankMap.put(players[i], i);
            playerMap.put(i, players[i]);
        }
        for (String calling : callings){
            int rank = rankMap.get(calling);
            rankMap.put(calling, rank-1);
            rankMap.put(playerMap.get(rank-1), rank);
            playerMap.put(rank, playerMap.get(rank-1));
            playerMap.put(rank-1, calling);
        }
        for (int i = 0; i < players.length; i++)
            answer[i] = playerMap.get(i);
        return answer;
    }
}