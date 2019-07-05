package Java8;

import java.util.Arrays;
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
	}
}
