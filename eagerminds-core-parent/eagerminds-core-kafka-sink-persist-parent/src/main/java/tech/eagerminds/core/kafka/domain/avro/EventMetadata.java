/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package tech.eagerminds.core.kafka.domain.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EventMetadata extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7980614594813274336L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventMetadata\",\"namespace\":\"tech.eagerminds.core.kafka.domain.avro\",\"fields\":[{\"name\":\"dateCreated\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"origin\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"traceId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"user\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EventMetadata> ENCODER =
      new BinaryMessageEncoder<EventMetadata>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EventMetadata> DECODER =
      new BinaryMessageDecoder<EventMetadata>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EventMetadata> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EventMetadata> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EventMetadata> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EventMetadata>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EventMetadata to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EventMetadata from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EventMetadata instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EventMetadata fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String dateCreated;
  private java.lang.String origin;
  private java.lang.String traceId;
  private java.lang.String user;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventMetadata() {}

  /**
   * All-args constructor.
   * @param dateCreated The new value for dateCreated
   * @param origin The new value for origin
   * @param traceId The new value for traceId
   * @param user The new value for user
   */
  public EventMetadata(java.lang.String dateCreated, java.lang.String origin, java.lang.String traceId, java.lang.String user) {
    this.dateCreated = dateCreated;
    this.origin = origin;
    this.traceId = traceId;
    this.user = user;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dateCreated;
    case 1: return origin;
    case 2: return traceId;
    case 3: return user;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dateCreated = value$ != null ? value$.toString() : null; break;
    case 1: origin = value$ != null ? value$.toString() : null; break;
    case 2: traceId = value$ != null ? value$.toString() : null; break;
    case 3: user = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'dateCreated' field.
   * @return The value of the 'dateCreated' field.
   */
  public java.lang.String getDateCreated() {
    return dateCreated;
  }


  /**
   * Sets the value of the 'dateCreated' field.
   * @param value the value to set.
   */
  public void setDateCreated(java.lang.String value) {
    this.dateCreated = value;
  }

  /**
   * Gets the value of the 'origin' field.
   * @return The value of the 'origin' field.
   */
  public java.lang.String getOrigin() {
    return origin;
  }


  /**
   * Sets the value of the 'origin' field.
   * @param value the value to set.
   */
  public void setOrigin(java.lang.String value) {
    this.origin = value;
  }

  /**
   * Gets the value of the 'traceId' field.
   * @return The value of the 'traceId' field.
   */
  public java.lang.String getTraceId() {
    return traceId;
  }


  /**
   * Sets the value of the 'traceId' field.
   * @param value the value to set.
   */
  public void setTraceId(java.lang.String value) {
    this.traceId = value;
  }

  /**
   * Gets the value of the 'user' field.
   * @return The value of the 'user' field.
   */
  public java.lang.String getUser() {
    return user;
  }


  /**
   * Sets the value of the 'user' field.
   * @param value the value to set.
   */
  public void setUser(java.lang.String value) {
    this.user = value;
  }

  /**
   * Creates a new EventMetadata RecordBuilder.
   * @return A new EventMetadata RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder newBuilder() {
    return new tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder();
  }

  /**
   * Creates a new EventMetadata RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventMetadata RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder newBuilder(tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder other) {
    if (other == null) {
      return new tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder();
    } else {
      return new tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder(other);
    }
  }

  /**
   * Creates a new EventMetadata RecordBuilder by copying an existing EventMetadata instance.
   * @param other The existing instance to copy.
   * @return A new EventMetadata RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder newBuilder(tech.eagerminds.core.kafka.domain.avro.EventMetadata other) {
    if (other == null) {
      return new tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder();
    } else {
      return new tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder(other);
    }
  }

  /**
   * RecordBuilder for EventMetadata instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventMetadata>
    implements org.apache.avro.data.RecordBuilder<EventMetadata> {

    private java.lang.String dateCreated;
    private java.lang.String origin;
    private java.lang.String traceId;
    private java.lang.String user;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dateCreated)) {
        this.dateCreated = data().deepCopy(fields()[0].schema(), other.dateCreated);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.origin)) {
        this.origin = data().deepCopy(fields()[1].schema(), other.origin);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.traceId)) {
        this.traceId = data().deepCopy(fields()[2].schema(), other.traceId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.user)) {
        this.user = data().deepCopy(fields()[3].schema(), other.user);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing EventMetadata instance
     * @param other The existing instance to copy.
     */
    private Builder(tech.eagerminds.core.kafka.domain.avro.EventMetadata other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.dateCreated)) {
        this.dateCreated = data().deepCopy(fields()[0].schema(), other.dateCreated);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.origin)) {
        this.origin = data().deepCopy(fields()[1].schema(), other.origin);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.traceId)) {
        this.traceId = data().deepCopy(fields()[2].schema(), other.traceId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.user)) {
        this.user = data().deepCopy(fields()[3].schema(), other.user);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'dateCreated' field.
      * @return The value.
      */
    public java.lang.String getDateCreated() {
      return dateCreated;
    }


    /**
      * Sets the value of the 'dateCreated' field.
      * @param value The value of 'dateCreated'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder setDateCreated(java.lang.String value) {
      validate(fields()[0], value);
      this.dateCreated = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'dateCreated' field has been set.
      * @return True if the 'dateCreated' field has been set, false otherwise.
      */
    public boolean hasDateCreated() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'dateCreated' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder clearDateCreated() {
      dateCreated = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'origin' field.
      * @return The value.
      */
    public java.lang.String getOrigin() {
      return origin;
    }


    /**
      * Sets the value of the 'origin' field.
      * @param value The value of 'origin'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder setOrigin(java.lang.String value) {
      validate(fields()[1], value);
      this.origin = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'origin' field has been set.
      * @return True if the 'origin' field has been set, false otherwise.
      */
    public boolean hasOrigin() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'origin' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder clearOrigin() {
      origin = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'traceId' field.
      * @return The value.
      */
    public java.lang.String getTraceId() {
      return traceId;
    }


    /**
      * Sets the value of the 'traceId' field.
      * @param value The value of 'traceId'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder setTraceId(java.lang.String value) {
      validate(fields()[2], value);
      this.traceId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'traceId' field has been set.
      * @return True if the 'traceId' field has been set, false otherwise.
      */
    public boolean hasTraceId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'traceId' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder clearTraceId() {
      traceId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'user' field.
      * @return The value.
      */
    public java.lang.String getUser() {
      return user;
    }


    /**
      * Sets the value of the 'user' field.
      * @param value The value of 'user'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder setUser(java.lang.String value) {
      validate(fields()[3], value);
      this.user = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'user' field has been set.
      * @return True if the 'user' field has been set, false otherwise.
      */
    public boolean hasUser() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'user' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EventMetadata.Builder clearUser() {
      user = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EventMetadata build() {
      try {
        EventMetadata record = new EventMetadata();
        record.dateCreated = fieldSetFlags()[0] ? this.dateCreated : (java.lang.String) defaultValue(fields()[0]);
        record.origin = fieldSetFlags()[1] ? this.origin : (java.lang.String) defaultValue(fields()[1]);
        record.traceId = fieldSetFlags()[2] ? this.traceId : (java.lang.String) defaultValue(fields()[2]);
        record.user = fieldSetFlags()[3] ? this.user : (java.lang.String) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EventMetadata>
    WRITER$ = (org.apache.avro.io.DatumWriter<EventMetadata>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EventMetadata>
    READER$ = (org.apache.avro.io.DatumReader<EventMetadata>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.dateCreated);

    if (this.origin == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.origin);
    }

    if (this.traceId == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.traceId);
    }

    if (this.user == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.user);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.dateCreated = in.readString();

      if (in.readIndex() != 1) {
        in.readNull();
        this.origin = null;
      } else {
        this.origin = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.traceId = null;
      } else {
        this.traceId = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.user = null;
      } else {
        this.user = in.readString();
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.dateCreated = in.readString();
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.origin = null;
          } else {
            this.origin = in.readString();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.traceId = null;
          } else {
            this.traceId = in.readString();
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.user = null;
          } else {
            this.user = in.readString();
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










