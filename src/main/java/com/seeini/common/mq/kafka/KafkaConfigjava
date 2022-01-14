package com.seeini.common.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author Color1995
 * @Date 2021/6/1 16:29
 * @Version 1.0
 * @Description
 */
@Configuration
public class KafkaConfig {

//    @Value("${kafka-pdf.address}")
    private String kafkaAddress;

//    @Value("${kafka-pdf.username}")
    private String kafkaUsername;

//    @Value("${kafka-pdf.password}")
    private String kafkaPassword;

//    @Bean
    public KafkaProducer<String,String> kafkaProducer(){

        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);//kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.ACKS_CONFIG, "all");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");
        // 批量发送的分区大小 128 kb
        p.put(ProducerConfig.BATCH_SIZE_CONFIG, 262144);
        // Batch无法存满的超时时间 10ms
//        p.put(ProducerConfig.LINGER_MS_CONFIG, "10");
        // buffer.memory 缓存区大小为 64M
        p.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 67108864);

        return new KafkaProducer<>(p);
    }

}
