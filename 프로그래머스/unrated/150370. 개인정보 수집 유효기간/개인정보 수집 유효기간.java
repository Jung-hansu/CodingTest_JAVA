import java.util.*;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for (String term : terms){
			String[] tmp = term.split(" ");
			map.put(tmp[0], Integer.parseInt(tmp[1]));
		}
		for (int i = 0; i < privacies.length; i++){
			String[] privacy = privacies[i].split(" ");
			if (!isValid(today, privacy[0], map.get(privacy[1]))) list.add(i+1);
		}
		list.sort(Comparator.naturalOrder());
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	private boolean isValid (String today, String Date, int mm){
		int[] T = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
		int[] date = Arrays.stream(Date.split("\\.")).mapToInt(Integer::parseInt).toArray();

		date[0] += (date[1] + mm - 1) / 12;
		date[1] = (date[1] + mm - 1) % 12 + 1;
		if (T[0] == date[0])
			if (T[1] == date[1]) return T[2] < date[2];
			else return T[1] < date[1];
		else return T[0] < date[0];
	}
}