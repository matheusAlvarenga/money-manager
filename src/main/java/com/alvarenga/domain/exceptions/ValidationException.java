package com.alvarenga.domain.exceptions;

public class ValidationException extends RuntimeException {
  private static final long serialVersionUID = 2212445323L;

  public ValidationException(String message) {
    super(message);
  }
}
