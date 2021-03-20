package com.shop.mq;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendEmailBoxProdcer {
    @Autowired
    private JmsMessagingTemplate  jmsMessagingTemplate;

    //生产者发送模板
    public   void  SendMsg(Destination destination,String  json){
        jmsMessagingTemplate.convertAndSend(destination,json);
    }
}
