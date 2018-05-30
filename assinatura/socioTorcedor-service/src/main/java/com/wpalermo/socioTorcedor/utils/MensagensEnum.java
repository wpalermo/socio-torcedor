package com.wpalermo.socioTorcedor.utils;

public enum MensagensEnum {
	
	SUCESSO("Operacao realizada com sucesso"),
	ERRO("Problema ao tentar realizar operacao");
	
	public String mensagem;
	
	private MensagensEnum(String mensagem) {
		this.mensagem = mensagem;
	}

}
