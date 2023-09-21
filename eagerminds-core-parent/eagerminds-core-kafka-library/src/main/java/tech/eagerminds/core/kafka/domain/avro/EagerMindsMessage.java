package tech.eagerminds.core.kafka.domain.avro;

import org.apache.avro.generic.GenericRecord;

public record EagerMindsMessage<K extends GenericRecord, V extends GenericRecord>(K key, V value) {

}