package fatec.edu.entidades;

public enum FormatosEnum {
	
	SEM_BROCHURA("Sem brochura",1),
	CAPA_MOLE("Capa-mole",2),
	CAPA_DURA("Capa-dura",3);
	
	private int codigoFormato;
	
	private String descFormato;
	
	FormatosEnum(final String descFormato, final int codigoFormato) {
		this.codigoFormato = codigoFormato;
		this.descFormato = descFormato;
	}
	
	public static FormatosEnum getFormatoBrochuraEnum(final int codigoFormato){
		for(final FormatosEnum formatoBrochuraEnum : values()){
			if(formatoBrochuraEnum.codigoFormato == codigoFormato){
				return formatoBrochuraEnum;
			}
		}
		
		return SEM_BROCHURA;
	}
	
	public int getCodigoFormato(){
		return this.codigoFormato;
	}
	
	public String getDescFormato(){
		return this.descFormato;
	}
}
