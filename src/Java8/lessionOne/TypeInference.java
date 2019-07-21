package Java8.lessionOne;

public class TypeInference {


	interface StringLengthLambda {
		int getLength(String s);
	}

	public static void printLambda(StringLengthLambda lambda) {
		System.out.println(lambda.getLength("Hello World!"));
	}


	public static void main(String[] args) {
		printLambda(s -> s.length());
	}

}
