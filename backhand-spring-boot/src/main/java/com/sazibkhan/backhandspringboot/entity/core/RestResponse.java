package com.sazibkhan.backhandspringboot.entity.core;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@ToString
public class RestResponse {

  private Object data;
  private String message;
  private Integer statusCode;
  private Boolean status;
  private ZonedDateTime timestamp = ZonedDateTime.now();

  public RestResponse(Object data, String message, HttpStatus httpStatus, Boolean status) {
    this.data = data;
    this.message = message;
    this.statusCode = httpStatus.value();
    this.status = status;
  }

  public RestResponse(Object data, String message) {
    this.data = data;
    this.message = message;
    this.statusCode = HttpStatus.OK.value();
    this.status = Boolean.TRUE;
  }

  public RestResponse(String message, Boolean status) {
    this.message = message;
    this.statusCode = HttpStatus.OK.value();
    this.status = status;
  }

  public RestResponse(String message, HttpStatus httpStatus) {
    this.message = message;
    this.statusCode = httpStatus.value();
    this.status = Boolean.TRUE;
  }

  public RestResponse(Object data) {
    this.data = data;
    this.message = HttpStatus.OK.name();
    this.statusCode = HttpStatus.OK.value();
    this.status = Boolean.TRUE;
  }

  public RestResponse(String message) {
    this.message = message;
    this.statusCode = HttpStatus.OK.value();
    this.status = Boolean.TRUE;
  }

  public RestResponse() {
    this.message = ApiMessages.MESSAGE_SUCCESS;
    this.statusCode = HttpStatus.OK.value();
    this.status = Boolean.TRUE;
  }
}
