package com.sazibkhan.backhandspringboot.factory;
import com.sazibkhan.backhandspringboot.entity.core.ApiMessages;
import com.sazibkhan.backhandspringboot.entity.core.RestResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;

import java.util.UUID;

public class ResponseFactory {

  public static ResponseEntity<?> saveResponse(String message, HttpStatus httpStatus) {
    return ResponseEntity.status(httpStatus)
            .body(new RestResponse(message));
  }
  public static ResponseEntity<?> restResponse(Object data, HttpStatus httpStatus) {
    return ResponseEntity.status(httpStatus)
        .body(new RestResponse(data));
  }

  public static ResponseEntity<?> restResponse(Object data, String message) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(data, message));
  }

  public static ResponseEntity<?> restResponse(Object data) {
    return ResponseEntity.ok(new RestResponse(data));
  }

  public static ResponseEntity<?> restResponse(String message) {
    return ResponseEntity.ok(new RestResponse(message));
  }

  public static ResponseEntity<?> saveResponse() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(ApiMessages.MESSAGE_SUCCESS));
  }

  public static ResponseEntity<?> saveResponse(Object data) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(data, ApiMessages.MESSAGE_SUCCESS));
  }

  public static ResponseEntity<?> updateResponse() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(ApiMessages.MESSAGE_SUCCESS));
  }

  public static ResponseEntity<?> updateResponse(Object data) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(data, ApiMessages.MESSAGE_SUCCESS));
  }

  public static ResponseEntity<?> deleteResponse() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new RestResponse(ApiMessages.MESSAGE_SUCCESS));
  }

  public static ResponseEntity<?> errorResponse() {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new RestResponse(ApiMessages.BAD_REQUEST, HttpStatus.BAD_REQUEST));
  }

  public static ResponseEntity<?> errorResponse(String message) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new RestResponse(message, Boolean.FALSE));
  }

  public static ResponseEntity<?> errorResponse(Object data, String message) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new RestResponse(data, message));
  }

  public static ResponseEntity<?> exportReport(byte[] exportedReport) {

    String fileName = UUID.randomUUID().toString().concat(".pdf");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("filename", fileName);
    return ResponseEntity.status(HttpStatus.OK)
        .headers(headers)
        .body(exportedReport);
  }
}
