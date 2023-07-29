import java.util.*;

class Solution {
	private Set<Character> used = new HashSet<>();
	private StringBuilder sb;
	private String answer = "";

	public String solution(String sentence) {
		sb = new StringBuilder(sentence);

		//Check space
		if (sb.indexOf(" ") >= 0)
			return "invalid";

		//Check rules
		try{ checkRule(); }
		catch(Exception e){ return "invalid"; }

		//Check invalid parsing
		for (char c : answer.toCharArray())
			if (!(isUpper(c) || c == ' '))
				return "invalid";

		return answer.trim();
	}

	private void checkRule() throws Exception{
		StringBuilder s;
		char c;

		while (!sb.toString().equals("")) {
			s = parseWord();

			//Check rule 2
			if (!isUpper(c = s.charAt(0))) {
				//s.length() == 2 : consider the invalid cases like "aa"
				if (used.contains(c) || s.charAt(s.length()-1) != c || s.length() == 2)
					throw new Exception();
				used.add(c);
				s.deleteCharAt(0);
				s.deleteCharAt(s.length() - 1);
			}

			//Check rule 1
			if (s.length() > 1 && !isUpper(c = s.charAt(1))){
				if (used.contains(c))
					throw new Exception();
				used.add(c);
				for (int i = 1; i < s.length(); i++)
					if (s.charAt(i) != c || !isUpper(s.deleteCharAt(i).charAt(i)))
						throw new Exception();
			}

			answer += s.append(" ");
		}
	}

	private StringBuilder parseWord(){
		String ret;
		int idx;
		char c;

		if (sb.length() == 1) {
			ret = sb.substring(0, 1);
			sb.delete(0,1);
			return new StringBuilder(ret);
		}
		//Parse with rule 2
		if (!isUpper(c = sb.charAt(0))){
			for (idx = 1; idx < sb.length() && sb.charAt(idx) != c; idx++);
			if (idx == sb.length())
				return null;
			ret = sb.substring(0, idx+1);
			sb.delete(0, idx+1);
			return new StringBuilder(ret);
		}

		//Parse with rule 1
		if (!isUpper(c = sb.charAt(1))){
			int lowers = 1;
			for (idx = 2; idx < sb.length(); idx++)
				if (sb.charAt(idx) == c) lowers++;
			//lowers == 2 : When the word has only a character (ex. AaAa -> "A A")
			//lowers != 2 : When the word has several characters (ex. AaBaCaD -> "ABCD")
			if (lowers != 2) {
				for (idx = 1; idx < sb.length() && sb.charAt(idx) == c; idx += 2) ;
				ret = sb.substring(0, idx);
				sb.delete(0, idx);
				return new StringBuilder(ret);
			}
		}

		//Parse with no rule
		//Upper cases are always considered as only a character
		ret = sb.substring(0, 1);
		sb.delete(0, 1);
		return new StringBuilder(ret);
	}

	private boolean isUpper(char c){
		return c >= 'A' && c <= 'Z';
	}
}