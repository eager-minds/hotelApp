package tech.eagerminds.core.mongodb.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import tech.eagerminds.core.mongodb.annotation.CascadeSave;

@Document("eagermindsMessages")
public class EagerMindsMessageEntity {

  @Id
  private String id;

  private String value;

  @DBRef
  @Field("metadata")
  @CascadeSave
  private EagerMindsMetadataEntity metadata;

  public EagerMindsMessageEntity() {
  }

  public EagerMindsMessageEntity(String id, String value, EagerMindsMetadataEntity metadata) {
    this.id = id;
    this.value = value;
    this.metadata = metadata;
  }

  public String id() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String value() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public EagerMindsMetadataEntity metadata() {
    return metadata;
  }

  public void setMetadata(EagerMindsMetadataEntity metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return "EagerMindsMessageEntity{" +
        "id='" + id + '\'' +
        ", value='" + value + '\'' +
        ", metadata=" + metadata +
        '}';
  }
}
