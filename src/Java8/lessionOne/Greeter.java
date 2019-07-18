package Java8.lessionOne;

public class Greeter {

	public static void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("bc");
		StringBuilder sb2 = new StringBuilder("ab");
		StringBuilder sb3 = sb.append(sb2);
		sb2.deleteCharAt(sb2.length()-1);
		System.out.println(sb2.toString());

		MyLambda myLambda = () -> System.out.println("Hello world !!!");

		AddFunction addFunction = (int a, int b) -> a + b;
}


}
interface MyLambda {
	void foo();
}

interface AddFunction {
	int add(int x, int y);
}