package io.amit.accenture.jee_assessment.jms_playground;

import javax.jms.*;

public class MyListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {

            TextMessage text = (TextMessage) message;

            System.out.println("Received : " + text.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

}
