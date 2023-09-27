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
public class EagerMindsValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 98800766788404958L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EagerMindsValue\",\"namespace\":\"tech.eagerminds.core.kafka.domain.avro\",\"fields\":[{\"name\":\"entity\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"metadata\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"EventMetadata\",\"fields\":[{\"name\":\"dateCreated\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"origin\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"traceId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"user\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EagerMindsValue> ENCODER =
      new BinaryMessageEncoder<EagerMindsValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EagerMindsValue> DECODER =
      new BinaryMessageDecoder<EagerMindsValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EagerMindsValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EagerMindsValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EagerMindsValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EagerMindsValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EagerMindsValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EagerMindsValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EagerMindsValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EagerMindsValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String entity;
  private java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> metadata;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EagerMindsValue() {}

  /**
   * All-args constructor.
   * @param entity The new value for entity
   * @param metadata The new value for metadata
   */
  public EagerMindsValue(java.lang.String entity, java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> metadata) {
    this.entity = entity;
    this.metadata = metadata;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return entity;
    case 1: return metadata;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: entity = value$ != null ? value$.toString() : null; break;
    case 1: metadata = (java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'entity' field.
   * @return The value of the 'entity' field.
   */
  public java.lang.String getEntity() {
    return entity;
  }


  /**
   * Sets the value of the 'entity' field.
   * @param value the value to set.
   */
  public void setEntity(java.lang.String value) {
    this.entity = value;
  }

  /**
   * Gets the value of the 'metadata' field.
   * @return The value of the 'metadata' field.
   */
  public java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> getMetadata() {
    return metadata;
  }


  /**
   * Sets the value of the 'metadata' field.
   * @param value the value to set.
   */
  public void setMetadata(java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> value) {
    this.metadata = value;
  }

  /**
   * Creates a new EagerMindsValue RecordBuilder.
   * @return A new EagerMindsValue RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder newBuilder() {
    return new tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder();
  }

  /**
   * Creates a new EagerMindsValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EagerMindsValue RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder newBuilder(tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder other) {
    if (other == null) {
      return new tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder();
    } else {
      return new tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder(other);
    }
  }

  /**
   * Creates a new EagerMindsValue RecordBuilder by copying an existing EagerMindsValue instance.
   * @param other The existing instance to copy.
   * @return A new EagerMindsValue RecordBuilder
   */
  public static tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder newBuilder(tech.eagerminds.core.kafka.domain.avro.EagerMindsValue other) {
    if (other == null) {
      return new tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder();
    } else {
      return new tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for EagerMindsValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EagerMindsValue>
    implements org.apache.avro.data.RecordBuilder<EagerMindsValue> {

    private java.lang.String entity;
    private java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> metadata;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.entity)) {
        this.entity = data().deepCopy(fields()[0].schema(), other.entity);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.metadata)) {
        this.metadata = data().deepCopy(fields()[1].schema(), other.metadata);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing EagerMindsValue instance
     * @param other The existing instance to copy.
     */
    private Builder(tech.eagerminds.core.kafka.domain.avro.EagerMindsValue other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.entity)) {
        this.entity = data().deepCopy(fields()[0].schema(), other.entity);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.metadata)) {
        this.metadata = data().deepCopy(fields()[1].schema(), other.metadata);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'entity' field.
      * @return The value.
      */
    public java.lang.String getEntity() {
      return entity;
    }


    /**
      * Sets the value of the 'entity' field.
      * @param value The value of 'entity'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder setEntity(java.lang.String value) {
      validate(fields()[0], value);
      this.entity = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'entity' field has been set.
      * @return True if the 'entity' field has been set, false otherwise.
      */
    public boolean hasEntity() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'entity' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder clearEntity() {
      entity = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'metadata' field.
      * @return The value.
      */
    public java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> getMetadata() {
      return metadata;
    }


    /**
      * Sets the value of the 'metadata' field.
      * @param value The value of 'metadata'.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder setMetadata(java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> value) {
      validate(fields()[1], value);
      this.metadata = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'metadata' field has been set.
      * @return True if the 'metadata' field has been set, false otherwise.
      */
    public boolean hasMetadata() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'metadata' field.
      * @return This builder.
      */
    public tech.eagerminds.core.kafka.domain.avro.EagerMindsValue.Builder clearMetadata() {
      metadata = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EagerMindsValue build() {
      try {
        EagerMindsValue record = new EagerMindsValue();
        record.entity = fieldSetFlags()[0] ? this.entity : (java.lang.String) defaultValue(fields()[0]);
        record.metadata = fieldSetFlags()[1] ? this.metadata : (java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata>) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EagerMindsValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<EagerMindsValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EagerMindsValue>
    READER$ = (org.apache.avro.io.DatumReader<EagerMindsValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.entity);

    if (this.metadata == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.metadata.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (tech.eagerminds.core.kafka.domain.avro.EventMetadata e0: this.metadata) {
        actualSize0++;
        out.startItem();
        e0.customEncode(out);
      }
      out.writeArrayEnd();
      if (actualSize0 != size0)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.entity = in.readString();

      if (in.readIndex() != 1) {
        in.readNull();
        this.metadata = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> a0 = this.metadata;
        if (a0 == null) {
          a0 = new SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata>((int)size0, SCHEMA$.getField("metadata").schema().getTypes().get(1));
          this.metadata = a0;
        } else a0.clear();
        SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            tech.eagerminds.core.kafka.domain.avro.EventMetadata e0 = (ga0 != null ? ga0.peek() : null);
            if (e0 == null) {
              e0 = new tech.eagerminds.core.kafka.domain.avro.EventMetadata();
            }
            e0.customDecode(in);
            a0.add(e0);
          }
        }
      }

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.entity = in.readString();
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.metadata = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<tech.eagerminds.core.kafka.domain.avro.EventMetadata> a0 = this.metadata;
            if (a0 == null) {
              a0 = new SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata>((int)size0, SCHEMA$.getField("metadata").schema().getTypes().get(1));
              this.metadata = a0;
            } else a0.clear();
            SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<tech.eagerminds.core.kafka.domain.avro.EventMetadata>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                tech.eagerminds.core.kafka.domain.avro.EventMetadata e0 = (ga0 != null ? ga0.peek() : null);
                if (e0 == null) {
                  e0 = new tech.eagerminds.core.kafka.domain.avro.EventMetadata();
                }
                e0.customDecode(in);
                a0.add(e0);
              }
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










