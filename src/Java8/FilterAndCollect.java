package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAndCollect {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "hamza");

		List<String> result = lines.stream()
													.filter(line -> !"hamza".equals(line))
													.collect(Collectors.toList());

		result.forEach(System.out::println);

		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		Stream<String> stream = stringList.stream();

		stream.flatMap((value) -> {
			String[] split = value.split(" ");
			return (Stream<String>) Arrays.asList(split).stream();
		})
				.forEach((value) -> System.out.println(value))
		;

	}

}
