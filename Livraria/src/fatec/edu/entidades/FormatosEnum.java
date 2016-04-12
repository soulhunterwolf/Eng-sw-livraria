package fatec.edu.entidades;

public enum FormatosEnum {
	//Opções da Enum com o dígito 
	CAPADURA(1),
	CAPAMOLE(2); 
	
	//Indicador do índice da opção
	private final int valor;
	
	//Construtor
	FormatosEnum(int opcao){
		valor = opcao;
	}
	
	public int getValor(){
		return valor;
	}
}
