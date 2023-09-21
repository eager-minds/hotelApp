package tech.eagerminds.core.kafka.producer.test.helper;

import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.GenericMessageConverter;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;

public class MessageHelper {

  private MessageHelper() {
//    Nothing to do
  }

  @SuppressWarnings("unchecked")
  public static <T> T parse(Message<byte[]> message, Class<T> clazz) {
    return (T) new GenericMessageConverter().fromMessage(message, clazz);
  }

  public static <K> K getMessageKey(MessageHeaders headers, Class<K> clazz) {
    Object key = headers.containsKey(KafkaHeaders.KEY) ?
        headers.get(KafkaHeaders.KEY) :
        headers.get(KafkaHeaders.RECEIVED_KEY);
    return clazz.cast(key);
  }

  public static <K extends GenericRecord, V extends GenericRecord> boolean compareMessages(
      EagerMindsMessage<K, V> publishEagerMindsMessage, Message<V> receivedMessage) {
    return getMessageKey(receivedMessage.getHeaders(), publishEagerMindsMessage.key().getClass())
        .equals(publishEagerMindsMessage.key())
        && publishEagerMindsMessage.value().equals(receivedMessage.getPayload());
  }

  public static boolean compareMessages(String sentPlainMessage, Message<String> receivedMessage) {
    return receivedMessage.getPayload().equals(sentPlainMessage);
  }
}
