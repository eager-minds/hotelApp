package tech.eagerminds.core.kafka.consumer.bdd.registrytype;

import io.cucumber.java.DocStringType;
import tech.eagerminds.core.kafka.domain.avro.EagerMindsValue;

public class DocStringRegistryType {

  @DocStringType
  public EagerMindsValue eagerminds_value_json(String docString) {
    return EagerMindsValue.newBuilder().setEntity(docString).build();
  }
}
