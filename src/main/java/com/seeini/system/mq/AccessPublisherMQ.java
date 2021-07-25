package com.seeini.system.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@PropertySource({"classpath:rabbitmq.properties"})
public class AccessPublisherMQ {

    /**
     * 通用交换机：此处选用Topic类型
     */
    @Value("${universal.topic.exchange.name}")
    private String universalTopicExchange;

    /**
     * 通用队列1
     */
    @Value("${universal.queue.no1.name}")
    private String universalQueueNo1;

    /**
     * 通用队列2
     */
    @Value("${universal.queue.no2.name}")
    private String universalQueueNo2;



    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param msg  消息
     */
    public void send(Object msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(universalTopicExchange, "universalRoutingKeyA.access",msg,correlationId);




        //确认消息是否到达broker服务器，也就是只确认是否正确到达exchange中即可，只要正确的到达exchange中，broker即可确认该消息返回给客户端ack。
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback(){
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                if (ack) {
//                    System.out.println("消息确认成功");
//                } else {
//                    //处理丢失的消息（nack）
//                    System.out.println("消息确认失败");
//                }
//            }
//        });
    }
}
