package com.talent.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.talent.constant.RabbitMQConstant;

public class MQMain {
    public static void main(String[] args) {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(RabbitMQConstant.API_EXCHANGE_NAME, "direct");

            channel.queueDeclare(RabbitMQConstant.API_QUEUE_NAME, true, false, false, null);
            channel.queueBind(RabbitMQConstant.API_QUEUE_NAME, RabbitMQConstant.API_EXCHANGE_NAME, RabbitMQConstant.API_ROUTING_KEY);

        } catch (Exception e) {

        }
    }
}