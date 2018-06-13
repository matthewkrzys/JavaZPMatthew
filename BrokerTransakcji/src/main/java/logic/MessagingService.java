package logic;

import jms.JmsProducerQueue;
import jms.JmsProducerTopic;
import model.CommandData;

public class MessagingService{
    private JmsProducerQueue jmsProducerQueue;
    private JmsProducerTopic jmsProducerTopic;


    public void checkIfMessagingAndSend(CommandData commandData) throws Exception {
        if (!commandData.getBroker().equals("")){
            if (!commandData.getQueue().equals("")){
                jmsProducerQueue = new JmsProducerQueue(commandData.getBroker(), commandData.getQueue());
                jmsProducerQueue.sendMessage(String.valueOf(commandData));
            }
            if (!commandData.getTopic().equals("")){
                jmsProducerTopic = new JmsProducerTopic(commandData.getBroker(), commandData.getTopic());
                jmsProducerTopic.sendMessage(String.valueOf(commandData));
            }
        }
    }
}