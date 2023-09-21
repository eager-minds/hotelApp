package tech.eagerminds.core.kafka.domain.avro;

public record EagerMindsPlainMessage<K>(K key, String value) {

}