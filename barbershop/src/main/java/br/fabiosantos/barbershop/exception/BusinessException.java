package br.fabiosantos.barbershop.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4127734375653122590L;
	@Getter
    protected int errorCode;

    public BusinessException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
