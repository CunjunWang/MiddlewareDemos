package com.cunjunwang.activemqdemo.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by CunjunWang on 2018/9/14.
 */
public class AppConsumer {

    private static final String url = "tcp://127.0.0.1:61616";
    private static final String topicName = "topic-test";

    // 主题模式下必须提前订阅主题
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
        // 6. 创建Consumer
        MessageConsumer consumer = session.createConsumer(destination);
        // 7. 创建监听Listener
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("收到消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        // 8. 关闭连接
        // connection.close();
    }

}
