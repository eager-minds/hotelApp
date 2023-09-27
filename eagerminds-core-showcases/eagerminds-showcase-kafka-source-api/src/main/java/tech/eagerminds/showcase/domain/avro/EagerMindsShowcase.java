/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package tech.eagerminds.showcase.domain.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class EagerMindsShowcase extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8280700253758516459L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EagerMindsShowcase\",\"namespace\":\"tech.eagerminds.showcase.domain.avro\",\"fields\":[{\"name\":\"myString\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"myInt\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"myIntArray\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EagerMindsShowcase> ENCODER =
      new BinaryMessageEncoder<EagerMindsShowcase>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EagerMindsShowcase> DECODER =
      new BinaryMessageDecoder<EagerMindsShowcase>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<EagerMindsShowcase> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<EagerMindsShowcase> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<EagerMindsShowcase> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EagerMindsShowcase>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this EagerMindsShowcase to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a EagerMindsShowcase from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a EagerMindsShowcase instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static EagerMindsShowcase fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String myString;
  private java.lang.Integer myInt;
  private java.util.List<java.lang.Integer> myIntArray;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EagerMindsShowcase() {}

  /**
   * All-args constructor.
   * @param myString The new value for myString
   * @param myInt The new value for myInt
   * @param myIntArray The new value for myIntArray
   */
  public EagerMindsShowcase(java.lang.String myString, java.lang.Integer myInt, java.util.List<java.lang.Integer> myIntArray) {
    this.myString = myString;
    this.myInt = myInt;
    this.myIntArray = myIntArray;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return myString;
    case 1: return myInt;
    case 2: return myIntArray;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: myString = value$ != null ? value$.toString() : null; break;
    case 1: myInt = (java.lang.Integer)value$; break;
    case 2: myIntArray = (java.util.List<java.lang.Integer>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'myString' field.
   * @return The value of the 'myString' field.
   */
  public java.lang.String getMyString() {
    return myString;
  }


  /**
   * Sets the value of the 'myString' field.
   * @param value the value to set.
   */
  public void setMyString(java.lang.String value) {
    this.myString = value;
  }

  /**
   * Gets the value of the 'myInt' field.
   * @return The value of the 'myInt' field.
   */
  public java.lang.Integer getMyInt() {
    return myInt;
  }


  /**
   * Sets the value of the 'myInt' field.
   * @param value the value to set.
   */
  public void setMyInt(java.lang.Integer value) {
    this.myInt = value;
  }

  /**
   * Gets the value of the 'myIntArray' field.
   * @return The value of the 'myIntArray' field.
   */
  public java.util.List<java.lang.Integer> getMyIntArray() {
    return myIntArray;
  }


  /**
   * Sets the value of the 'myIntArray' field.
   * @param value the value to set.
   */
  public void setMyIntArray(java.util.List<java.lang.Integer> value) {
    this.myIntArray = value;
  }

  /**
   * Creates a new EagerMindsShowcase RecordBuilder.
   * @return A new EagerMindsShowcase RecordBuilder
   */
  public static tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder newBuilder() {
    return new tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder();
  }

  /**
   * Creates a new EagerMindsShowcase RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EagerMindsShowcase RecordBuilder
   */
  public static tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder newBuilder(tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder other) {
    if (other == null) {
      return new tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder();
    } else {
      return new tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder(other);
    }
  }

  /**
   * Creates a new EagerMindsShowcase RecordBuilder by copying an existing EagerMindsShowcase instance.
   * @param other The existing instance to copy.
   * @return A new EagerMindsShowcase RecordBuilder
   */
  public static tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder newBuilder(tech.eagerminds.showcase.domain.avro.EagerMindsShowcase other) {
    if (other == null) {
      return new tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder();
    } else {
      return new tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder(other);
    }
  }

  /**
   * RecordBuilder for EagerMindsShowcase instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EagerMindsShowcase>
    implements org.apache.avro.data.RecordBuilder<EagerMindsShowcase> {

    private java.lang.String myString;
    private java.lang.Integer myInt;
    private java.util.List<java.lang.Integer> myIntArray;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.myString)) {
        this.myString = data().deepCopy(fields()[0].schema(), other.myString);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.myInt)) {
        this.myInt = data().deepCopy(fields()[1].schema(), other.myInt);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.myIntArray)) {
        this.myIntArray = data().deepCopy(fields()[2].schema(), other.myIntArray);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing EagerMindsShowcase instance
     * @param other The existing instance to copy.
     */
    private Builder(tech.eagerminds.showcase.domain.avro.EagerMindsShowcase other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.myString)) {
        this.myString = data().deepCopy(fields()[0].schema(), other.myString);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.myInt)) {
        this.myInt = data().deepCopy(fields()[1].schema(), other.myInt);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.myIntArray)) {
        this.myIntArray = data().deepCopy(fields()[2].schema(), other.myIntArray);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'myString' field.
      * @return The value.
      */
    public java.lang.String getMyString() {
      return myString;
    }


    /**
      * Sets the value of the 'myString' field.
      * @param value The value of 'myString'.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder setMyString(java.lang.String value) {
      validate(fields()[0], value);
      this.myString = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'myString' field has been set.
      * @return True if the 'myString' field has been set, false otherwise.
      */
    public boolean hasMyString() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'myString' field.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder clearMyString() {
      myString = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'myInt' field.
      * @return The value.
      */
    public java.lang.Integer getMyInt() {
      return myInt;
    }


    /**
      * Sets the value of the 'myInt' field.
      * @param value The value of 'myInt'.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder setMyInt(java.lang.Integer value) {
      validate(fields()[1], value);
      this.myInt = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'myInt' field has been set.
      * @return True if the 'myInt' field has been set, false otherwise.
      */
    public boolean hasMyInt() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'myInt' field.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder clearMyInt() {
      myInt = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'myIntArray' field.
      * @return The value.
      */
    public java.util.List<java.lang.Integer> getMyIntArray() {
      return myIntArray;
    }


    /**
      * Sets the value of the 'myIntArray' field.
      * @param value The value of 'myIntArray'.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder setMyIntArray(java.util.List<java.lang.Integer> value) {
      validate(fields()[2], value);
      this.myIntArray = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'myIntArray' field has been set.
      * @return True if the 'myIntArray' field has been set, false otherwise.
      */
    public boolean hasMyIntArray() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'myIntArray' field.
      * @return This builder.
      */
    public tech.eagerminds.showcase.domain.avro.EagerMindsShowcase.Builder clearMyIntArray() {
      myIntArray = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EagerMindsShowcase build() {
      try {
        EagerMindsShowcase record = new EagerMindsShowcase();
        record.myString = fieldSetFlags()[0] ? this.myString : (java.lang.String) defaultValue(fields()[0]);
        record.myInt = fieldSetFlags()[1] ? this.myInt : (java.lang.Integer) defaultValue(fields()[1]);
        record.myIntArray = fieldSetFlags()[2] ? this.myIntArray : (java.util.List<java.lang.Integer>) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EagerMindsShowcase>
    WRITER$ = (org.apache.avro.io.DatumWriter<EagerMindsShowcase>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EagerMindsShowcase>
    READER$ = (org.apache.avro.io.DatumReader<EagerMindsShowcase>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.myString == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.myString);
    }

    if (this.myInt == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeInt(this.myInt);
    }

    if (this.myIntArray == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.myIntArray.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (java.lang.Integer e0: this.myIntArray) {
        actualSize0++;
        out.startItem();
        out.writeInt(e0);
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
      if (in.readIndex() != 1) {
        in.readNull();
        this.myString = null;
      } else {
        this.myString = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.myInt = null;
      } else {
        this.myInt = in.readInt();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.myIntArray = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<java.lang.Integer> a0 = this.myIntArray;
        if (a0 == null) {
          a0 = new SpecificData.Array<java.lang.Integer>((int)size0, SCHEMA$.getField("myIntArray").schema().getTypes().get(1));
          this.myIntArray = a0;
        } else a0.clear();
        SpecificData.Array<java.lang.Integer> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Integer>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            java.lang.Integer e0 = (ga0 != null ? ga0.peek() : null);
            e0 = in.readInt();
            a0.add(e0);
          }
        }
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.myString = null;
          } else {
            this.myString = in.readString();
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.myInt = null;
          } else {
            this.myInt = in.readInt();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.myIntArray = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<java.lang.Integer> a0 = this.myIntArray;
            if (a0 == null) {
              a0 = new SpecificData.Array<java.lang.Integer>((int)size0, SCHEMA$.getField("myIntArray").schema().getTypes().get(1));
              this.myIntArray = a0;
            } else a0.clear();
            SpecificData.Array<java.lang.Integer> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.Integer>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                java.lang.Integer e0 = (ga0 != null ? ga0.peek() : null);
                e0 = in.readInt();
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









