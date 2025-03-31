package com.nr.student.config;

import com.nr.student.model.StudentPersonalInfo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.producer.key-serializer}")
    private String producerKeySerializer;
    @Value("${spring.kafka.producer.value-serializer}")
    private String producerValueSerializer;
    @Value("${spring.kafka.consumer.key-deserializer}")
    private String consumerKeyDeSerializer;
    @Value("${spring.kafka.consumer.value-deserializer}")
    private String consumerValueDeSerializer;
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Bean
    public ConsumerFactory<String, StudentPersonalInfo> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, consumerKeyDeSerializer);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, consumerValueDeSerializer);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.nr.student.*");

        return new DefaultKafkaConsumerFactory<>(
                configProps,
                new StringDeserializer(),
                new JsonDeserializer<>(StudentPersonalInfo.class)  // ✅ Fix: Correctly deserialize JSON into `Student`
        );
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StudentPersonalInfo> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StudentPersonalInfo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory()); //require consumerFactory Object
        return factory;
    }
}
