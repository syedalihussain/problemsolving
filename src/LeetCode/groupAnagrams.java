package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int index = 0, size = 0;
		List<List<String>> res = new ArrayList<List<String>>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sorted = String.valueOf(charArray);
			if (hm.containsKey(sorted)) {
				index = hm.get(sorted);
				List<String> oldList = res.get(index);
				oldList.add(str);
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(str);
				res.add(newList);
				hm.put(sorted, size);
				size++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] list = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> res = groupAnagrams(list);
//		for (List<String> l : res) {
//			System.out.println(l.get);
//		}
		String str = "hello";
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		System.out.println(String.valueOf(charArray));
	}
}
