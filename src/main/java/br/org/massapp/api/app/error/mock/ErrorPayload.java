package br.org.massapp.api.app.error.mock;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorPayload(
    String code,
    String message,
    List<ErrorDetail> details,
    LocalDateTime timestamp,
    String path
) {}
