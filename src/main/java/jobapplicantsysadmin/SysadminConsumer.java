package jobapplicantsysadmin;

import com.rabbitmq.client.DeliverCallback;
import config.RabbitMQConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class SysadminConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        var channel = RabbitMQConfig.getConnection().createChannel();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            var message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            SysadminService.getApplicant(message);
        };
        channel.basicConsume("sysadmin", true, deliverCallback, consumerTag -> { });
    }

}
