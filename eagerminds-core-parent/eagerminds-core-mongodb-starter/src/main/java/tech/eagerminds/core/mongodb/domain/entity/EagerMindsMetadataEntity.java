package tech.eagerminds.core.mongodb.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("eagermindsMetadatas")
public class EagerMindsMetadataEntity {

  @Id
  private String id;
  private String dateCreated;
  private String origin;
  private String traceId;
  private String user;

  public EagerMindsMetadataEntity() {
  }

  public EagerMindsMetadataEntity(String id, String dateCreated, String origin, String traceId,
      String user) {
    this.id = id;
    this.dateCreated = dateCreated;
    this.origin = origin;
    this.traceId = traceId;
    this.user = user;
  }

  public String id() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String dateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String origin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String traceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  public String user() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "EagerMindsMetadataEntity{"
        + "id='" + id + '\''
        + ", dateCreated='" + dateCreated + '\''
        + ", origin='" + origin + '\''
        + ", traceId='" + traceId + '\''
        + ", user='" + user + '\''
        + '}';
  }
}
