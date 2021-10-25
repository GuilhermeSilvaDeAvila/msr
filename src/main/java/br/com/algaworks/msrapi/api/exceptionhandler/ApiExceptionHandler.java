package br.com.algaworks.msrapi.api.exceptionhandler;

import br.com.algaworks.msrapi.domain.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Problem messageError = new Problem();
        List<Problem.Detail> details = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            details.add(new Problem.Detail(nome, mensagem));
        }

        messageError.setStatus(status.value());
        messageError.setMessage("Valores inválidos");
        messageError.setDetails(details);

        return handleExceptionInternal(ex, messageError, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Problem messageError = new Problem();

        messageError.setStatus(status.value());
        messageError.setMessage(ex.getMessage());

        return handleExceptionInternal(ex, messageError, new HttpHeaders(), status, request);
    }
}
