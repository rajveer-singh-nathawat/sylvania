package com.org.sylvania.exception;

public class IncorrectCredentialException extends Exception {

  public IncorrectCredentialException(String errorMessage) {
    super(errorMessage);
  }

  private static final long serialVersionUID = 1L;

}
