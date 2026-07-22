package io.amit.accenture.jee_assessment.jms_playground;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageConsumerExample {

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection =
                factory.createConnection();

        connection.start();

        Session session =
                connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);

        Queue queue =
                session.createQueue("MY_QUEUE");

        MessageConsumer consumer =
                session.createConsumer(queue);

        TextMessage message =
                (TextMessage) consumer.receive();

        System.out.println(message.getText());

        consumer.close();
        session.close();
        connection.close();
    }

}