package com.seeini.common.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Color2020
 *
 * 消息队列
 * 交换机，队列的声明
 */

@Slf4j
@PropertySource({"classpath:rabbitmq.properties"})
@Configuration
public class RabbitMQConfig {


    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);

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
     * 通用路由键 *
     */
    private String routingKey1;

    /**
     * 通用路由键 #
     */
    private String routingKey2;


    /**
     *   1.topic exchange，绑定queueTest
     *   2.durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *     fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *     topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     *   key: queue在该direct-exchange中的key值，当消息发送给direct-exchange中指定key为设置值时，
     *   消息将会转发给queue参数指定的消息队列
     */
    @Bean
    public TopicExchange universalTopicExchange(){
        TopicExchange topicExchange = new TopicExchange(universalTopicExchange,true,false);
        return topicExchange;
    }

    @Bean
    public Queue universalQueueNo1() {
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(universalQueueNo1,true,false,false);
    }

    @Bean
    public Queue universalQueueNo2() {
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(universalQueueNo2,true,false,false);
    }

    /**
     将消息队列1和通用交换机进行绑定
     */
    @Bean
    public Binding queueNo1BindingUniversalExchange() {
        return BindingBuilder.bind(universalQueueNo1()).to(universalTopicExchange()).with("universalRoutingKeyA.#");
    }

    /**
     * 将消息队列2和交换机进行绑定
     */
    @Bean
    public Binding queueNo2BindingUniversalExchange() {
        return BindingBuilder.bind(universalQueueNo2()).to(universalTopicExchange()).with("universalRoutingKeyB.#");
    }


    /** ======================== 定制一些处理策略 =============================*/

    /**
     * 定制化amqp模版
     *
     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        Logger log = LoggerFactory.getLogger(RabbitTemplate.class);

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);

        // 消息返回, yml需要配置 publisher-returns: true
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            logger.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        });

        // 消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                 logger.info("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                logger.info("消息发送到exchange失败,原因: {}", cause);
            }
        });

        return rabbitTemplate;
    }

}
