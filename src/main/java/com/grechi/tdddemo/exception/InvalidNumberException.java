package com.grechi.tdddemo.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidNumberException extends RuntimeException {

    private String message;
}
