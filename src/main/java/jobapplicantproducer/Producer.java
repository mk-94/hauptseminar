package jobapplicantproducer;

import config.RabbitMQConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Producer {

    public void publishMessage(String message, String exchange, String binding) throws IOException, TimeoutException {
        var channel = RabbitMQConfig.getConnection().createChannel();
        channel.basicPublish(exchange, binding, null, message.getBytes(StandardCharsets.UTF_8));
    }

}
