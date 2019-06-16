package CtCI_Recursion_and_Dynamic_Programming;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class powerSet_08_04 {

	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			ArrayList<Integer> emptySet = new ArrayList<>();
			allsubsets = new ArrayList<>();
			allsubsets.add(emptySet);
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<>(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}


	public static void main(String[] args) {
		ArrayList<Integer> combinations = new ArrayList<>();
		combinations.add(1);
		combinations.add(2);
		combinations.add(3);

		ArrayList<ArrayList<Integer>> res = getSubsets(combinations, 0);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
