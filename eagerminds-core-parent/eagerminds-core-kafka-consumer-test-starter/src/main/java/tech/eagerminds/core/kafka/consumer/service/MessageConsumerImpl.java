package tech.eagerminds.core.kafka.consumer.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.avro.generic.GenericRecord;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.library.service.MessageConsumer;

@Service
public class MessageConsumerImpl implements MessageConsumer {

  public static final List<Message> RECEIVED_MESSAGES = new ArrayList<>();

  @Override
  public <V extends GenericRecord> void messageProcessor(Message<V> message) {
    MessageConsumer.super.messageProcessor(message);
    RECEIVED_MESSAGES.add(message);
  }
}
