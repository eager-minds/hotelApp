package tech.eagerminds.showcase.domain.entity;

import java.util.List;
import org.springframework.data.annotation.Id;

public class EagerMindsShowcaseEntity {

  @Id
  private String id;

  private String myString;
  private Integer myInt;
  private List<Integer> myIntArray;

  public EagerMindsShowcaseEntity() {
  }

  public EagerMindsShowcaseEntity(String id, String myString, Integer myInt,
      List<Integer> myIntArray) {
    this.id = id;
    this.myString = myString;
    this.myInt = myInt;
    this.myIntArray = myIntArray;
  }

  public String id() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String myString() {
    return myString;
  }

  public void setMyString(String myString) {
    this.myString = myString;
  }

  public Integer myInt() {
    return myInt;
  }

  public void setMyInt(Integer myInt) {
    this.myInt = myInt;
  }

  public List<Integer> myIntArray() {
    return myIntArray;
  }

  public void setMyIntArray(List<Integer> myIntArray) {
    this.myIntArray = myIntArray;
  }

  @Override
  public String toString() {
    return "EagerMindsShowcaseEntity{"
        + "id='" + id + '\''
        + ", myString='" + myString + '\''
        + ", myInt=" + myInt
        + ", myIntArray=" + myIntArray
        + '}';
  }
}
