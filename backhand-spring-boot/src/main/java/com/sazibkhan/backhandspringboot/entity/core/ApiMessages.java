package com.sazibkhan.backhandspringboot.entity.core;

public interface ApiMessages {

  String ROLE_ADMIN = "Admin";
  String ROLE_USER = "User";
  Integer USER_LEVEL = 1;
  String MESSAGE_SUCCESS = "success";
  String MESSAGE_FAILED = "failed";
  String MESSAGE_DUPLICATE = "duplicate";
  String MESSAGE_UNAUTHORIZED = "Unauthorized";
  String MESSAGE_TOKEN_EXPIRED = "Token has been expired !!!";
  String MESSAGE_INVALID_TOKEN = "Valid token is required to access the protected resources !!!";
  String CAN_NOT_PROCESS_REQUEST= "cannot process request !!!";
  String INVALID_ACCESS= "Invalid access to protected resources !!!";
  String BAD_REQUEST = "Woops! Something went wrong !!!";
}
