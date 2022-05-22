package br.ifpe.web.enums;

public enum Estados {

	PE("Pernambuco"),
	BA("Bahia"),
	PB("Paraíba"),
	CE("Ceará"),
	MA("Maranhão");
	
	private String nome;
	
	Estados(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
