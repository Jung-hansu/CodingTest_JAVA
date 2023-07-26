import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] pos = findS(park), answer = pos.clone();
        
        for (String route : routes){
            String[] tmp = route.split(" ");
            int[] dir = switch(tmp[0]){
                        case "E" -> new int[]{0, 1};
                        case "W" -> new int[]{0, -1};
                        case "S" -> new int[]{1, 0};
                        case "N" -> new int[]{-1, 0};
                        default -> null;};
            for (int i = 0; i < Integer.parseInt(tmp[1]); i++){
                pos[0] += dir[0];
                pos[1] += dir[1];
                if (!isMovable(pos, park)){
                    pos = answer.clone();
                    break;
                }
            }
            answer = pos.clone();
        }
        return answer;
    }
    
    private int[] findS(String[] park){
        for (int i = 0; i < park.length; i++)
            for (int j = 0; j < park[0].length(); j++)
                if (park[i].charAt(j) == 'S')
                    return new int[]{i, j};
        return null;
    }
    
    private boolean isMovable(int[] pos, String[] park){
        return pos[0] >= 0 && pos[0] < park.length &&
                pos[1] >= 0 && pos[1] < park[0].length() &&
                park[pos[0]].charAt(pos[1]) != 'X';
    }
}