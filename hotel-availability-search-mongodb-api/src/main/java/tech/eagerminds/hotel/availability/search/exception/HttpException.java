package tech.eagerminds.hotel.availability.search.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {

  private final HttpStatus httpStatus;

  public HttpException(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public HttpStatus httpStatus() {
    return httpStatus;
  }
}
