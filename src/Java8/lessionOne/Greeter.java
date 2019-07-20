package Java8.lessionOne;

public class Greeter {

	public static void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {

		Greeter greeter = new Greeter();
		Greeting helloWorldGreeting = new HelloWorldGreeting();
		Greeting lambdaGreeting = () -> System.out.println("Hello world lambda!!!");

		Greeting innerClassGreeting = new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hello World inner");
			}
		};

		lambdaGreeting.perform();
		helloWorldGreeting.perform();
		innerClassGreeting.perform();
	}


}