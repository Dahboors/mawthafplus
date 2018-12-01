package com.mwathafplus.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MerchantNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -173271584183400716L;

	public MerchantNotFoundException() {
		super("Merchant not found !!");
	}
}
