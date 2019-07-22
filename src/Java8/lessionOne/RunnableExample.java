package Java8.lessionOne;

public class RunnableExample {

	public static void main(String[] args) {

		Thread myThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
		});

		myThread.run();

		Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		myLambdaThread.run();

		System.out.println(Integer.toBinaryString(-3));

	}

}
