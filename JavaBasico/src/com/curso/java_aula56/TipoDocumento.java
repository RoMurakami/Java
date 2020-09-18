package com.curso.java_aula56;

public enum TipoDocumento {
	
	CPF {
		@Override
		public String geraNumeroDocumento() {
			return GeraCpfCnpj.cpf();
		}
	}, CNPJ {
		@Override
		public String geraNumeroDocumento() {
			return GeraCpfCnpj.cnpj();
		}
	};
	
	
	
	public abstract String geraNumeroDocumento();

}
