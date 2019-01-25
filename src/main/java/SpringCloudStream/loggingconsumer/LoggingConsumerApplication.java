package SpringCloudStream.loggingconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

//We have enabled Sink binding (input-no-output) by using @EnableBinding(Sink.class). Doing so signals to the framework to initiate
// binding to the messaging middleware, where it automatically creates the destination (that is, queue, topic, and others) that are bound
// to the Sink.INPUT channel.
@SpringBootApplication
@EnableBinding(Sink.class)
public class LoggingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle( Person person){
		System.out.println("Received Person : "+person);
	}

//	@Bean
//	public void pooling message(PollableMessageSource source, )

	public static class Person{
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					'}';
		}
	}

}

