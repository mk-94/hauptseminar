package config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConfig {

    private static Connection connection = null;

    public static Connection getConnection() throws IOException, TimeoutException {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        return connection;
    }

    public static void createExchange(String exchangeName, BuiltinExchangeType builtinExchangeType, boolean durable) throws IOException, TimeoutException {
        var channel = getConnection().createChannel();
        channel.exchangeDeclare(exchangeName, builtinExchangeType, durable);
    }

    public static void createQueue(String queueName) throws IOException, TimeoutException {
        var channel =  getConnection().createChannel();
        channel.queueDeclare(queueName, true, false, false, null);
    }

    public static void bindQueue(String queueName, String exchangeName, String binding) throws IOException, TimeoutException {
        var channel =  getConnection().createChannel();
        channel.queueBind(queueName, exchangeName, binding);
    }

}
