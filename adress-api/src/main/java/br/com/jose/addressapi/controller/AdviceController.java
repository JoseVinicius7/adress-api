package br.com.jose.addressapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jose.addressapi.controller.dto.ErroDeFormularioDto;
import br.com.jose.addressapi.exception.AddressNotFoundException;
import br.com.jose.addressapi.exception.GeocodingException;

@RestControllerAdvice
public class AdviceController {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException ex) {
		
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e ->{
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
		
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handle(AddressNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(GeocodingException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handle(GeocodingException ex) {
		return ex.getMessage();
	}

}
