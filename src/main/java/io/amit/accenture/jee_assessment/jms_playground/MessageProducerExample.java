package io.amit.accenture.jee_assessment.jms_playground;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageProducerExample {

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

        MessageProducer producer =
                session.createProducer(queue);

        TextMessage message =
                session.createTextMessage("Hello from JMS Producer");

        producer.send(message);

        System.out.println("Message Sent");

        producer.close();
        session.close();
        connection.close();
    }

}
