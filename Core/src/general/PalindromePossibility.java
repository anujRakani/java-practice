package general;

import java.util.HashMap;
import java.util.Map;

public class PalindromePossibility {
	public static void main(String[] args) {
		PalindromePossibility i1 = new PalindromePossibility();
		
		System.out.println(i1.checkPalindrome("ccdebbaaaa".toCharArray()));
		
	}
	
	public String checkPalindrome(char[] chars) {
		int evenCount = 0;
		int oddCount = 0;
		
		Map<Character, Integer> hm = countOccurences(chars);
		
		for (Map.Entry<Character, Integer> hmEvenOdd : hm.entrySet()) {
			if (hmEvenOdd.getValue() % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		
		System.out.println("even: "+evenCount+"   odd: " + oddCount);
		
		if (oddCount > 1 && hm.size() == 1) {
			// if odd count not 1 but only one character
			return "Yes";
		} else if (oddCount == 0 && evenCount > 0) {
			return "Yes";
		} else if (oddCount == 1 && evenCount >= 0) {
			// if one odd and count value is 1 and all other even
			return "Yes";
		} else {
			return "No";
		}
		
	}
	
	public HashMap<Character,Integer> countOccurences(char[] chars) {
		HashMap<Character, Integer> hm = new HashMap<>();
		HashMap<Character, Boolean> hmEvenOdd = new HashMap<>();
		
		int count = 0;
		
		for (char c : chars) {
			if (hm.containsKey(c)) {
				count = hm.get(c);
				hm.put(c, ++count);
			} else {
				hm.put(c, 1);
			}
		}
		
		return  hm;
	}
}



// Write a program to check whether any given random string can form 
// palindrome or not if characters of the string are re-arranged, 
// the output should be yes if possible or else no
