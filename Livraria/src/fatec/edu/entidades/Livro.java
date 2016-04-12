package fatec.edu.entidades;

import java.util.Date;
import java.util.List;

public class Livro {

	private List<Autor> autor;
	private String editora;
	private String resumoLivro;
	private String sumario;
	private FormatosEnum formato;
	private int numPaginas;
	private Date dataPublicacao;
	private String titutlo;
	private int isbn;
	public List<Autor> getAutor() {
		return autor;
	}
	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumoLivro() {
		return resumoLivro;
	}
	public void setResumoLivro(String resumoLivro) {
		this.resumoLivro = resumoLivro;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public FormatosEnum getFormato() {
		return formato;
	}
	public void setFormato(FormatosEnum formato) {
		this.formato = formato;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getTitutlo() {
		return titutlo;
	}
	public void setTitutlo(String titutlo) {
		this.titutlo = titutlo;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public void addLivro(){
		
	}
	
	public void rmvLivro(){
		
	}
}
