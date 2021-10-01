package config;

import com.rabbitmq.client.BuiltinExchangeType;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Creator {

    private static final String SYSADMIN_QUEUE = "sysadmin";
    private static final String SOFTWAREDEV_QUEUE = "software_development";
    private static final String OTHERS_QUEUE = "other_applicants";
    private static final String LOGGING_QUEUE = "logging";
    private static final String EXCHANGE_NAME = "applicant";

    public static void main(String[] args) throws IOException, TimeoutException {
        RabbitMQConfig.createExchange(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, true);
        RabbitMQConfig.createQueue(SYSADMIN_QUEUE);
        RabbitMQConfig.createQueue(SOFTWAREDEV_QUEUE);
        RabbitMQConfig.createQueue(OTHERS_QUEUE);
        RabbitMQConfig.createQueue(LOGGING_QUEUE);

        RabbitMQConfig.bindQueue(SYSADMIN_QUEUE, EXCHANGE_NAME, "job.sysadmin");
        RabbitMQConfig.bindQueue(SOFTWAREDEV_QUEUE, EXCHANGE_NAME, "job.swdev");
        RabbitMQConfig.bindQueue(OTHERS_QUEUE, EXCHANGE_NAME, "job.others.*");
        RabbitMQConfig.bindQueue(LOGGING_QUEUE, EXCHANGE_NAME, "#");
    }

}
