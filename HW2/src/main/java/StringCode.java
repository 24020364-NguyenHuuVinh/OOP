import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int countMax = 1;
        int currentCount = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentCount++;
            } else {
                if (currentCount > countMax) {
                    countMax = currentCount;
                }
                currentCount = 1;
            }
        }
        if (currentCount > countMax) {
            countMax = currentCount;
        }
		return countMax; // YOUR CODE HERE
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                int count = currentChar - '0';
                if (i < str.length() - 1) {
                    char nextChar = str.charAt(i + 1);
                    for (int j = 0; j < count; j++) {
                        result.append(nextChar);
                    }
                }
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        if (len <= 0 || a.length() < len || b.length() < len) {
            return false;
        }
        Set<String> subA = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            String sub = a.substring(i, i + len);
            subA.add(sub);
        }
        for (int j = 0; j <= b.length() - len; j++) {
            String sub = b.substring(j, j + len);
            if (subA.contains(sub)) {
                return true;
            }
        }
        return false;
	}
}
