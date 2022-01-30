package com.osf.digital.lojas.config.validacao;

public class ErroDeFormularioDtoLojas {
	
	private String campo;
	private String erro;

	public ErroDeFormularioDtoLojas(String campo, String erro) {

		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
