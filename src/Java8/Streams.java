package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Streams {

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0)
	};

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
