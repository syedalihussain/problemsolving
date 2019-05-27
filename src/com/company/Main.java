package com.company;

public class Main {


	static boolean isAnagram(String a, String b) {

		if (a.length() != b.length())
			return false;
		char[] charArrayA = a.toLowerCase().toCharArray();
		char[] charArrayB = b.toLowerCase().toCharArray();

		int[] frequencies = new int[26];

		for (int i=0; i<a.length(); i++) {
			//System.out.println((int) frequencies[i]);
			//System.out.println((int) charArrayA[1]-104);
			frequencies[(int) charArrayA[i]-97]++;
			frequencies[(int) charArrayB[i]-97]--;
		}

		for (int i=0; i<frequencies.length; i++) {
			if (frequencies[i]!=0)
				return false;
		}

		return true;
	}

    public static void main(String[] args) {
	// write your code here



		System.out.println("Hello World!");
		String A = "Hello";
		String B = "hello";
		boolean res = isAnagram(A,B);
		System.out.println(res);
    }
}
