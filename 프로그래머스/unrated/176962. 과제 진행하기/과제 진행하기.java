import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Stack<String[]> works = new Stack<>();
        List<String> answer = new ArrayList<>();
        int i = 0;
        
        Arrays.sort(plans, Comparator.comparing(o->getTime(o)));
        works.push(plans[i++]);
        while (i < plans.length){
            int timeGap = getTime(plans[i]) - getTime(works.peek());
            int remainTime = Integer.parseInt(works.peek()[2]);
            if (remainTime > timeGap){
                works.peek()[2] = String.valueOf(remainTime - timeGap);
                works.push(plans[i++]);}
            else{
                int nowTime = getTime(works.peek()) + remainTime;
                answer.add(works.pop()[0]);
                if (!works.isEmpty())
                    works.peek()[1] = (nowTime/60) + ":" + (nowTime%60);}
            
            if (works.isEmpty()) works.push(plans[i++]);
        }
        
        while (!works.isEmpty())
            answer.add(works.pop()[0]);
        return answer.toArray(String[]::new);
    }
    
    private int getTime(String[] plan){
        int[] time = Arrays.stream(plan[1].split(":")).mapToInt(Integer::parseInt).toArray();
        return time[0]*60 + time[1];
    }
}