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
		//	Weekend function
		public void shouldCountWords() {
			final List<String> inputValues = Arrays.asList(
					"Hello Kafka Streams",
					"All streams lead to Kafka",
					"Join Kafka Summit",
					"И теперь пошли русские слова"
			);
			final Map<String, Long> expectedWordCounts = mkMap(
					mkEntry("hello", 1L),
					mkEntry("all", 1L),
					mkEntry("streams", 2L),
					mkEntry("lead", 1L),
					mkEntry("to", 1L),
					mkEntry("join", 1L),
					mkEntry("kafka", 3L),
					mkEntry("summit", 1L),
					mkEntry("и", 1L),
					mkEntry("теперь", 1L),
					mkEntry("пошли", 1L),
					mkEntry("русские", 1L),
					mkEntry("слова", 1L)
			);

			//
			// Step 1: Configure and start the processor topology.
			//
			final Serde<String> stringSerde = Serdes.String();
			final Serde<Long> longSerde = Serdes.Long();

			final Properties streamsConfiguration = new Properties();
			streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-lambda-integration-test");
			streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy config");
			streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
			streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
			// Use a temporary directory for storing state, which will be automatically removed after the test.
			streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, TestUtils.tempDirectory().getAbsolutePath());

			final StreamsBuilder builder = new StreamsBuilder();

			final KStream<String, String> textLines = builder.stream(inputTopic);

			final Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

			final KTable<String, Long> wordCounts = textLines
					.flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
					// no need to specify explicit serdes because the resulting key and value types match our default serde settings
					.groupBy((key, word) -> word)
					.count();

			wordCounts.toStream().to(outputTopic, Produced.with(stringSerde, longSerde));

			try (final TopologyTestDriver topologyTestDriver = new TopologyTestDriver(builder.build(), streamsConfiguration)) {
				//
				// Step 2: Produce some input data to the input topic.
				//
				IntegrationTestUtils.produceKeyValuesSynchronously(
						inputTopic,
						inputValues.stream().map(v -> new KeyValue<>(null, v)).collect(Collectors.toList()),
						topologyTestDriver,
						new IntegrationTestUtils.NothingSerde<>(),
						new StringSerializer()
				);

				//
				// Step 3: Verify the application's output data.
				//
				final Map<String, Long> actualWordCounts = IntegrationTestUtils.drainTableOutput(
						outputTopic,
						topologyTestDriver,
						new StringDeserializer(),
						new LongDeserializer()
				);
				assertThat(actualWordCounts).isEqualTo(expectedWordCounts);
			}
		}
}


}
interface MyLambda {
	void foo();
}

interface AddFunction {
	int add(int x, int y);
}