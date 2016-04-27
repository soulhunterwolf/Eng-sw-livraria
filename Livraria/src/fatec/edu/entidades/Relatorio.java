package fatec.edu.entidades;

import java.util.List;

public class Relatorio {
	
	private List<Autor> autorMaisVendido;
	private int qtdMaisVendido;
	private List<Cliente> clienteMaisFreq;
	
	public List<Autor> getAutorMaisVendido() {
		return autorMaisVendido;
	}
	public void setAutorMaisVendido(List<Autor> autorMaisVendido) {
		this.autorMaisVendido = autorMaisVendido;
	}
	public int getQtdMaisVendido() {
		return qtdMaisVendido;
	}
	public void setQtdMaisVendido(int qtdMaisVendido) {
		this.qtdMaisVendido = qtdMaisVendido;
	}
	public List<Cliente> getClienteMaisFreq() {
		return clienteMaisFreq;
	}
	public void setClienteMaisFreq(List<Cliente> clienteMaisFreq) {
		this.clienteMaisFreq = clienteMaisFreq;
	}
	
	public String calcularQtdMaisVendido(){
		return "";
	}
	
	public List<Autor> buscarAutoresMaisVendidos(){
		return null;
	}
}
