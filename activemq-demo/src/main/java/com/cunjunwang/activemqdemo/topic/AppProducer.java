package com.cunjunwang.activemqdemo.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by CunjunWang on 2018/9/14.
 */
public class AppProducer {

    private static final String url = "tcp://127.0.0.1:61616";
    private static final String topicName = "topic-test";

    public static void main(String[] args) throws JMSException {
        // 1. 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        // 2. 创建Connection
        Connection connection = connectionFactory.createConnection();
        // 3. 启动连接
        connection.start();
        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建Destination
        Destination destination = session.createTopic(topicName);
        // 6. 创建生产者
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 100; i++) {
            // 7. 创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            // 8. 发送消息
            producer.send(textMessage);
            System.out.println("消息发送成功：" + textMessage.getText());
        }
        // 9. 关闭连接
        connection.close();
    }
}
