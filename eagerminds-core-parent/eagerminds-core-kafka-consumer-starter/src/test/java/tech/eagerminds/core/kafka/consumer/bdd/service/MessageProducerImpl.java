package tech.eagerminds.core.kafka.consumer.bdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import tech.eagerminds.core.kafka.library.service.MessageProducer;

@Service
public class MessageProducerImpl implements MessageProducer {

  private final StreamBridge streamBridge;

  @Autowired
  public MessageProducerImpl(StreamBridge streamBridge) {
    this.streamBridge = streamBridge;
  }

  @Override
  public void sendMessage(String bindingName, Object messageString) {
    streamBridge.send(bindingName, messageString);
  }
}