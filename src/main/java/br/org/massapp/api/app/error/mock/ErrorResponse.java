package br.org.massapp.api.app.error.mock;


public record ErrorResponse(
    boolean success,
    int statusCode,
    ErrorPayload error
) {}
