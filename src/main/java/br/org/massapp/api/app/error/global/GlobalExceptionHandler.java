package br.org.massapp.api.app.error.global;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.org.massapp.api.app.error.mock.ErrorDetail;
import br.org.massapp.api.app.error.mock.ErrorPayload;
import br.org.massapp.api.app.error.mock.ErrorResponse;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof ConstraintViolationException) {
            return handleConstraintViolation((ConstraintViolationException) exception);
        } else if (exception instanceof NotFoundException) {
            return handleNotFound((NotFoundException) exception);
        } else {
            return handleGenericException(exception);
        }
    }

    // Trata erros de validação do DTO (Jakarta Validation)
    private Response handleConstraintViolation(ConstraintViolationException ex) {
        List<ErrorDetail> details = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString().split("\\.")[2]; // Extrai o nome do campo (ex: "createUser.user.email")
            details.add(new ErrorDetail(fieldName, violation.getMessage()));
        }

        ErrorResponse errorResponse = new ErrorResponse(
            false,
            Response.Status.BAD_REQUEST.getStatusCode(),
            new ErrorPayload(
                "VALIDATION_ERROR",
                "Erro de validação nos campos fornecidos",
                details,
                LocalDateTime.now(),
                getRequestPath()
            )
        );

        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(errorResponse)
            .build();
    }

    // Trata erros "Not Found" (404)
    private Response handleNotFound(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            false,
            Response.Status.NOT_FOUND.getStatusCode(),
            new ErrorPayload(
                "NOT_FOUND",
                ex.getMessage(),
                null,
                LocalDateTime.now(),
                getRequestPath()
            )
        );

        return Response
            .status(Response.Status.NOT_FOUND)
            .entity(errorResponse)
            .build();
    }

    // Trata erros genéricos (500)
    private Response handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            false,
            Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
            new ErrorPayload(
                "INTERNAL_ERROR",
                "Ocorreu um erro inesperado no servidor",
                null,
                LocalDateTime.now(),
                getRequestPath()
            )
        );

        return Response
            .status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(errorResponse)
            .build();
    }

    // Obtém o path da requisição (simplificado)
    private String getRequestPath() {
        return jakarta.ws.rs.core.UriInfo.class.cast(
            jakarta.ws.rs.core.SecurityContext.class.cast(
                jakarta.ws.rs.core.Context.class.cast(null)
            )
        ).getPath();
    }
}