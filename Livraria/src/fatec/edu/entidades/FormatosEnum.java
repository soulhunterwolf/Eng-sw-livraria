package fatec.edu.entidades;

public enum FormatosEnum {
	//Op��es da Enum com o d�gito 
	CAPADURA(1),
	CAPAMOLE(2); 
	
	//Indicador do �ndice da op��o
	private final int valor;
	
	//Construtor
	FormatosEnum(int opcao){
		valor = opcao;
	}
	
	public int getValor(){
		return valor;
	}
}
