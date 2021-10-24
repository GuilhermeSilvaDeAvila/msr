package br.com.algaworks.msrapi.domain.exception;

public class BusinessException extends RuntimeException{

    private static final long serialverisonUID = 1L;

    public BusinessException(String message){
        super(message);
    }

}
