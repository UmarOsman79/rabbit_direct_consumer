package gmail.umarosman77.consumer.service;

import gmail.umarosman77.consumer.model.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${rabbitmq.queue:test.rabbit.queue}")
	public void receiveMessage(Person person) {
		System.out.printf("Received message from queue: %s%n", person.toString());
	}
}
