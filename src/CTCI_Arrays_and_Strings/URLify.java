package CTCI_Arrays_and_Strings;

public class URLify {

	public static void urlify(char[] url, int len) {
		char c;
		char d;
		int rp = url.length - 1;
		int fp = 0;
		for(int i=len-1; i>=0; i--) {
			c = url[i];
			if (c != ' ') {
				url[rp--] = c;
			} else {
				url[rp--] = '0';
				url[rp--] = '2';
				url[rp--] = '%';
			}
		}

	}


	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] charArray = str.toCharArray();
		urlify(charArray, 13);
		StringBuilder sb = new StringBuilder();
		sb.append(charArray);
		System.out.println(sb.toString());

	}
}
