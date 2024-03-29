/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package tech.eagerminds.hotel.availability.search.domain.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AvailabilitySearch extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1305641121311974919L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvailabilitySearch\",\"namespace\":\"tech.eagerminds.hotel.availability.search.domain.avro\",\"fields\":[{\"name\":\"hotelId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"checkIn\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"checkOut\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"ages\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"int\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AvailabilitySearch> ENCODER =
      new BinaryMessageEncoder<AvailabilitySearch>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AvailabilitySearch> DECODER =
      new BinaryMessageDecoder<AvailabilitySearch>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AvailabilitySearch> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AvailabilitySearch> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AvailabilitySearch> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AvailabilitySearch>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AvailabilitySearch to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AvailabilitySearch from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AvailabilitySearch instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AvailabilitySearch fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String hotelId;
  private java.lang.String checkIn;
  private java.lang.String checkOut;
  private java.util.List<java.lang.Integer> ages;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvailabilitySearch() {}

  /**
   * All-args constructor.
   * @param hotelId The new value for hotelId
   * @param checkIn The new value for checkIn
   * @param checkOut The new value for checkOut
   * @param ages The new value for ages
   */
  public AvailabilitySearch(java.lang.String hotelId, java.lang.String checkIn, java.lang.String checkOut, java.util.List<java.lang.Integer> ages) {
    this.hotelId = hotelId;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.ages = ages;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return hotelId;
    case 1: return checkIn;
    case 2: return checkOut;
    case 3: return ages;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: hotelId = value$ != null ? value$.toString() : null; break;
    case 1: checkIn = value$ != null ? value$.toString() : null; break;
    case 2: checkOut = value$ != null ? value$.toString() : null; break;
    case 3: ages = (java.util.List<java.lang.Integer>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'hotelId' field.
   * @return The value of the 'hotelId' field.
   */
  public java.lang.String getHotelId() {
    return hotelId;
  }


  /**
   * Sets the value of the 'hotelId' field.
   * @param value the value to set.
   */
  public void setHotelId(java.lang.String value) {
    this.hotelId = value;
  }

  /**
   * Gets the value of the 'checkIn' field.
   * @return The value of the 'checkIn' field.
   */
  public java.lang.String getCheckIn() {
    return checkIn;
  }


  /**
   * Sets the value of the 'checkIn' field.
   * @param value the value to set.
   */
  public void setCheckIn(java.lang.String value) {
    this.checkIn = value;
  }

  /**
   * Gets the value of the 'checkOut' field.
   * @return The value of the 'checkOut' field.
   */
  public java.lang.String getCheckOut() {
    return checkOut;
  }


  /**
   * Sets the value of the 'checkOut' field.
   * @param value the value to set.
   */
  public void setCheckOut(java.lang.String value) {
    this.checkOut = value;
  }

  /**
   * Gets the value of the 'ages' field.
   * @return The value of the 'ages' field.
   */
  public java.util.List<java.lang.Integer> getAges() {
    return ages;
  }


  /**
   * Sets the value of the 'ages' field.
   * @param value the value to set.
   */
  public void setAges(java.util.List<java.lang.Integer> value) {
    this.ages = value;
  }

  /**
   * Creates a new AvailabilitySearch RecordBuilder.
   * @return A new AvailabilitySearch RecordBuilder
   */
  public static tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder newBuilder() {
    return new tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder();
  }

  /**
   * Creates a new AvailabilitySearch RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvailabilitySearch RecordBuilder
   */
  public static tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder newBuilder(tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder other) {
    if (other == null) {
      return new tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder();
    } else {
      return new tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder(other);
    }
  }

  /**
   * Creates a new AvailabilitySearch RecordBuilder by copying an existing AvailabilitySearch instance.
   * @param other The existing instance to copy.
   * @return A new AvailabilitySearch RecordBuilder
   */
  public static tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder newBuilder(tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch other) {
    if (other == null) {
      return new tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder();
    } else {
      return new tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder(other);
    }
  }

  /**
   * RecordBuilder for AvailabilitySearch instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvailabilitySearch>
    implements org.apache.avro.data.RecordBuilder<AvailabilitySearch> {

    private java.lang.String hotelId;
    private java.lang.String checkIn;
    private java.lang.String checkOut;
    private java.util.List<java.lang.Integer> ages;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.hotelId)) {
        this.hotelId = data().deepCopy(fields()[0].schema(), other.hotelId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.checkIn)) {
        this.checkIn = data().deepCopy(fields()[1].schema(), other.checkIn);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.checkOut)) {
        this.checkOut = data().deepCopy(fields()[2].schema(), other.checkOut);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.ages)) {
        this.ages = data().deepCopy(fields()[3].schema(), other.ages);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing AvailabilitySearch instance
     * @param other The existing instance to copy.
     */
    private Builder(tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.hotelId)) {
        this.hotelId = data().deepCopy(fields()[0].schema(), other.hotelId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.checkIn)) {
        this.checkIn = data().deepCopy(fields()[1].schema(), other.checkIn);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.checkOut)) {
        this.checkOut = data().deepCopy(fields()[2].schema(), other.checkOut);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ages)) {
        this.ages = data().deepCopy(fields()[3].schema(), other.ages);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'hotelId' field.
      * @return The value.
      */
    public java.lang.String getHotelId() {
      return hotelId;
    }


    /**
      * Sets the value of the 'hotelId' field.
      * @param value The value of 'hotelId'.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder setHotelId(java.lang.String value) {
      validate(fields()[0], value);
      this.hotelId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'hotelId' field has been set.
      * @return True if the 'hotelId' field has been set, false otherwise.
      */
    public boolean hasHotelId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'hotelId' field.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder clearHotelId() {
      hotelId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'checkIn' field.
      * @return The value.
      */
    public java.lang.String getCheckIn() {
      return checkIn;
    }


    /**
      * Sets the value of the 'checkIn' field.
      * @param value The value of 'checkIn'.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder setCheckIn(java.lang.String value) {
      validate(fields()[1], value);
      this.checkIn = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'checkIn' field has been set.
      * @return True if the 'checkIn' field has been set, false otherwise.
      */
    public boolean hasCheckIn() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'checkIn' field.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder clearCheckIn() {
      checkIn = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'checkOut' field.
      * @return The value.
      */
    public java.lang.String getCheckOut() {
      return checkOut;
    }


    /**
      * Sets the value of the 'checkOut' field.
      * @param value The value of 'checkOut'.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder setCheckOut(java.lang.String value) {
      validate(fields()[2], value);
      this.checkOut = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'checkOut' field has been set.
      * @return True if the 'checkOut' field has been set, false otherwise.
      */
    public boolean hasCheckOut() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'checkOut' field.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder clearCheckOut() {
      checkOut = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'ages' field.
      * @return The value.
      */
    public java.util.List<java.lang.Integer> getAges() {
      return ages;
    }


    /**
      * Sets the value of the 'ages' field.
      * @param value The value of 'ages'.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder setAges(java.util.List<java.lang.Integer> value) {
      validate(fields()[3], value);
      this.ages = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'ages' field has been set.
      * @return True if the 'ages' field has been set, false otherwise.
      */
    public boolean hasAges() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'ages' field.
      * @return This builder.
      */
    public tech.eagerminds.hotel.availability.search.domain.avro.AvailabilitySearch.Builder clearAges() {
      ages = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AvailabilitySearch build() {
      try {
        AvailabilitySearch record = new AvailabilitySearch();
        record.hotelId = fieldSetFlags()[0] ? this.hotelId : (java.lang.String) defaultValue(fields()[0]);
        record.checkIn = fieldSetFlags()[1] ? this.checkIn : (java.lang.String) defaultValue(fields()[1]);
        record.checkOut = fieldSetFlags()[2] ? this.checkOut : (java.lang.String) defaultValue(fields()[2]);
        record.ages = fieldSetFlags()[3] ? this.ages : (java.util.List<java.lang.Integer>) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AvailabilitySearch>
    WRITER$ = (org.apache.avro.io.DatumWriter<AvailabilitySearch>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AvailabilitySearch>
    READER$ = (org.apache.avro.io.DatumReader<AvailabilitySearch>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.hotelId == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.hotelId);
    }

    if (this.checkIn == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.checkIn);
    }

    if (this.checkOut == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.checkOut);
    }

    if (this.ages == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.ages.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (java.lang.Integer e0: this.ages) {
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
        this.hotelId = null;
      } else {
        this.hotelId = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.checkIn = null;
      } else {
        this.checkIn = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.checkOut = null;
      } else {
        this.checkOut = in.readString();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ages = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<java.lang.Integer> a0 = this.ages;
        if (a0 == null) {
          a0 = new SpecificData.Array<java.lang.Integer>((int)size0, SCHEMA$.getField("ages").schema().getTypes().get(1));
          this.ages = a0;
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
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.hotelId = null;
          } else {
            this.hotelId = in.readString();
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.checkIn = null;
          } else {
            this.checkIn = in.readString();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.checkOut = null;
          } else {
            this.checkOut = in.readString();
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ages = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<java.lang.Integer> a0 = this.ages;
            if (a0 == null) {
              a0 = new SpecificData.Array<java.lang.Integer>((int)size0, SCHEMA$.getField("ages").schema().getTypes().get(1));
              this.ages = a0;
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










