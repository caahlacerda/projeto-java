package com.osf.digital.staff.config.validacao;

public class ErroDeFormularioDtoStaffs {
	
	private String campo;
	private String erro;

	public ErroDeFormularioDtoStaffs(String campo, String erro) {

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
