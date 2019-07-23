package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndCollect {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "hamza");

		List<String> result = lines.stream()
													.filter(line -> !"hamza".equals(line))
													.collect(Collectors.toList());

		result.forEach(System.out::println);

	}

}
