package com.example.mcdonaldordersystem.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> {
    private final T data;
    private final String message;
    private final HttpStatus statusCode;

    public Response(T data, String message, HttpStatus statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(data, "SUCCESS", HttpStatus.OK);
    }

    public static <T> Response<T> fail(String errorMessage) {
        return new Response<>(null ,errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
