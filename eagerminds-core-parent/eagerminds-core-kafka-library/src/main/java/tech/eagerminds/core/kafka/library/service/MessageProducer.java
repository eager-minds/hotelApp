package tech.eagerminds.core.kafka.library.service;

import org.apache.avro.generic.GenericRecord;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsMessage;

public interface MessageProducer {

  void publishMessage(String bindingName, String messageString);

  <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName,
      EagerMindsMessage<K, V> eagerMindsMessage);

  <K extends GenericRecord, V extends GenericRecord> void publishMessage(String bindingName, K eagerMindsKey,
      V eagerMindsValue);
}
