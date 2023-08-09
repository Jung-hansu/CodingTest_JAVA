import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        for (int n : num_list) list.add(n);
        if (list.get(list.size()-1) > list.get(list.size()-2))
            list.add(list.get(list.size()-1) - list.get(list.size()-2));
        else
            list.add(list.get(list.size()-1)*2);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}