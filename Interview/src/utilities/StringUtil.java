package utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtil {
	public static void swap(char[] input, int s, int e) {
		char tmp = input[s];
		input[s] = input[e];
		input[e] = tmp;
	}

	public static boolean isDuplicate(char[] input) {
		Map<Character, Integer> dupMap = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			dupMap.put(input[i], dupMap.getOrDefault(input[i], 0) + 1);
			if (dupMap.get(input[i]) > 1) {
				return true;
			}
		}
		return false;
	}

	public static int getUniqueCharacterLength(char[] input) {
		Set<Character> tmp = new HashSet<>();
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			if (tmp.add(input[i])) {
				result++;
			}
		}
		return result;
	}

	public static Map<Character, Integer> addStringToMap(Map<Character, Integer> container, char[] input) {
		if (input == null || input.length < 1) {
			return container;
		}

		for (int i = 0; i < input.length; i++) {
			container.put(input[i], container.getOrDefault(input[i], 0) + 1);
		}
		return container;
	}

	public static Set<Character> addStringToSet(Set<Character> container, char[] input) {
		if (input == null || input.length < 1) {
			return container;
		}

		for (int i = 0; i < input.length; i++) {
			container.add(input[i]);
		}
		return container;
	}
}
