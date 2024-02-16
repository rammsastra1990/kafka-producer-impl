package org.learning.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaProducerImpl {

     public  static final Logger log = LoggerFactory.getLogger(KafkaProducerImpl.class);
    public static void main(String[] args) {

        log.info("Kafka producer flow invoking: ");
        // Producer Properties
        Properties properties = new Properties();
        // localhost
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        // other producer props
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // Kakfa producer
        KafkaProducer<String , String> producer = new KafkaProducer<String,String>(properties);
        // Producer Record
        ProducerRecord<String,String> producerRecord = new ProducerRecord<>("producer_java" , "Hej");
        // Send Record
        producer.send(producerRecord);
        // Flush and Close
        producer.flush();
        producer.close();
    }
}