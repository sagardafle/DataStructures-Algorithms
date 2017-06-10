/*https://careercup.com/question?id=5636223029739520*/
import java.util.*;
public class LongestPalindromeShuffle {
	public static void main(String[] args) {
		LongestPalindromeShuffle longest = new LongestPalindromeShuffle();
		System.out.println(longest.longest("aabcbcbdcc"));
	}
	
	public String longest(String string) {
		if (string.length() == 0 || string == null) {
			return "";
		}
		
		StringBuffer palindrom = new StringBuffer();
		Map<Character, Integer> charBag = new HashMap<Character, Integer>();
		for (Character c : string.toCharArray()) {
			int totalChar = charBag.get(c) != null ? charBag.get(c) : 0;
			if ((totalChar + 1) % 2 == 0) {
				palindrom.append(c);
				palindrom = palindrom.insert(0, c);
				charBag.remove(c);
				continue;
			}
			charBag.put(c, ++totalChar);
		}
		
		if (charBag.size() > 0) {
			Iterator it = charBag.entrySet().iterator();
			Map.Entry pair = (Map.Entry<Character, Integer>)it.next();
			String c = pair.getKey().toString();
			palindrom.insert(palindrom.length()/2, c);
		}
		return palindrom.toString();
	}
}
