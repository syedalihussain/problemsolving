package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Streams {

	public static void main(String[] args) {
		int[][] myIntArray = {
				{ 1 },
				{ 1 },
				{ 1 },
				{ 1 }
		};

		int sum = Arrays.stream(myIntArray)
				.mapToInt(arr->IntStream.of(arr).sum()) // sum the inner array
				.sum();

		System.out.println(sum);

		System.out.println("The weekend is here!!!");
		List<Integer> list = new ArrayList<>();
		list.add(0, 1);
		System.out.println(list);
		StringBuilder sb = new StringBuilder();
		sb.append('3');
		sb.append('4');
		sb.deleteCharAt(0);
		System.out.println(Integer.parseInt(sb.toString()));
	}
}
