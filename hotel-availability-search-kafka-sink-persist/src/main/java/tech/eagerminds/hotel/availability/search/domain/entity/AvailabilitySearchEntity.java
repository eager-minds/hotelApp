package tech.eagerminds.hotel.availability.search.domain.entity;

import java.util.List;
import org.springframework.data.annotation.Id;

public class AvailabilitySearchEntity {

  @Id
  private String id;

  private String hotelId;
  private String checkIn;
  private String checkOut;
  private List<Integer> ages;

  public AvailabilitySearchEntity() {
  }

  public AvailabilitySearchEntity(String id, String hotelId, String checkIn, String checkOut,
      List<Integer> ages) {
    this.id = id;
    this.hotelId = hotelId;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.ages = ages;
  }

  public String id() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String hotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

  public String checkIn() {
    return checkIn;
  }

  public void setCheckIn(String checkIn) {
    this.checkIn = checkIn;
  }

  public String checkOut() {
    return checkOut;
  }

  public void setCheckOut(String checkOut) {
    this.checkOut = checkOut;
  }

  public List<Integer> ages() {
    return ages;
  }

  public void setAges(List<Integer> ages) {
    this.ages = ages;
  }

  @Override
  public String toString() {
    return "AvailabilitySearchEntity{" +
        "id='" + id + '\'' +
        ", hotelId='" + hotelId + '\'' +
        ", checkIn='" + checkIn + '\'' +
        ", checkOut='" + checkOut + '\'' +
        ", ages=" + ages +
        '}';
  }
}
