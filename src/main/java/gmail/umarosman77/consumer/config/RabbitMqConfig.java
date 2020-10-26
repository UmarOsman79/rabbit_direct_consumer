package gmail.umarosman77.consumer.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

@Configuration
public class RabbitMqConfig {

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainer(ErrorHandler errorHandler, ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setErrorHandler(errorHandler);
		factory.setDefaultRequeueRejected(false);
		factory.setMessageConverter(converter());
		return factory;
	}

	@Bean
	public ErrorHandler errorHandler() {
		return e -> System.out.println("You messed up");
	}

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
