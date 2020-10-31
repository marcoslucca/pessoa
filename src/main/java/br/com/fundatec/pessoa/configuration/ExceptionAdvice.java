package br.com.fundatec.pessoa.configuration;

import br.com.fundatec.pessoa.commons.ApiError;
import br.com.fundatec.pessoa.exceptions.DuplicatedCpfException;
import br.com.fundatec.pessoa.exceptions.IrregularCpfException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicatedCpfException.class)
    public ApiError onException(DuplicatedCpfException exception) {
        return new ApiError("DUPLICATED_CPF", extractMessage(exception));
    }

    private String extractMessage(Throwable exception) {
        if (exception.getCause() == null && exception.getMessage() != null) {
            return exception.getMessage();
        } else if (exception.getCause() == null && exception.getMessage() == null) {
            return "";
        } else {
            return exception.getCause().getLocalizedMessage();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IrregularCpfException.class)
    public ApiError onException(IrregularCpfException exception) {
        return new ApiError("IRREGULAR_CPF", extractMessage(exception));
    }


}
