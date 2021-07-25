package com.seeini.system.mq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.seeini.system.entity.Access;
import com.seeini.system.service.AccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@PropertySource({"classpath:rabbitmq.properties"})
public class AccessSubscriberMQ {

    private static final Logger logger = LoggerFactory.getLogger(AccessSubscriberMQ.class);

    @Autowired
    private AccessService accessService;

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



    /**
     * 处理
     * @param message  消息
     */
//    @RabbitListener(queues = {"UniversalQueueNo1","UniversalQueueNo2"}, containerFactory = "rabbitListenerContainerFactory")
//    public void receive(Object message) throws InterruptedException {
//        // Thread.sleep(3000);
//        // 处理消息
//        System.out.println("AccessSubscriber {} handleMessage :"+message);
//
//    }

    @RabbitHandler
    @RabbitListener(queues = {"UniversalQueueNo1"})
    public void process(Message message, Channel channel) throws IOException {
        Gson gson = new Gson();
        Access access = gson.fromJson(new String(message.getBody()), Access.class);
        logger.info("Subscriber queue: UniversalQueueNo1, message：{}, ", new String(message.getBody()));
        int count = accessService.insert(access);
        if (count>0){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }
    }
}
