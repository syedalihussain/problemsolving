package LeetCode;

public class longestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		else if (strs.length == 1)
			return strs[0];

		int start = 0;
		int end = strs[0].length();
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			end = Math.min(end, strs[i].length());
			if (!strs[0].substring(start, end).equals(sb)){
				int j = 0;
				for (j = 0; j < end; j++) {
					if (sb.charAt(j) != strs[j].charAt(j)) {
						break;
					}
				}
				end = j;
				sb.delete(end, sb.length());
			}

			if ((end - start) == 1)
				return "";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs1 = new String[]{"dog","racecar","car"};
		String[] strs2 = new String[]{"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs1));
		System.out.println(longestCommonPrefix(strs2));
	}

}
