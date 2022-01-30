package com.osf.digital.clientes.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

	@RestControllerAdvice
	public class ErroDeValidacaoHandlerClientes {

		@Autowired
		private MessageSource messageSource;

		@ResponseStatus(code = HttpStatus.BAD_REQUEST)
		@ResponseBody
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public List<ErroDeFormularioDtoClientes> handle(MethodArgumentNotValidException exception) {

			List<ErroDeFormularioDtoClientes> dto = new ArrayList<ErroDeFormularioDtoClientes>();
			
			List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
			fieldErrors.forEach(e -> {
				String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
				ErroDeFormularioDtoClientes erro = new ErroDeFormularioDtoClientes(e.getField(), mensagem);
				dto.add(erro);
			});

			return dto;
		}

	}
