package jobapplicantlogger;

import com.rabbitmq.client.DeliverCallback;
import config.RabbitMQConfig;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class LoggerConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        BasicConfigurator.configure();
        var channel = RabbitMQConfig.getConnection().createChannel();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            LoggingService.log(message);
        };
        channel.basicConsume("logging", true, deliverCallback, consumerTag -> { });
    }
}
