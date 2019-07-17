package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

		Stream.of(arrayOfEmps);

		List<Employee> empList = Arrays.asList(arrayOfEmps);
		empList.stream();

		//	Increment the salary for all the employees
		empList.stream().forEach(e -> e.incrementSalary(10.0));


//		Integer[] empIds = {1,2,3};
//		List<Employee> employees = Stream.of(empIds)
//																	.filter(e -> e != null)
//																	.filter(e -> e.getSalary() > 20000)
//																	.collect(Collectors.toList());

	}
}
