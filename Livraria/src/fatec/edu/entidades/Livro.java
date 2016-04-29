package fatec.edu.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {

	@Column(name = "isbn", unique = true, length = 13)
	@Id
	private int isbn;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "isbn"), inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "nome"))
	private List<Autor> autor;
	private String editora;
	private String resumoLivro;
	private String sumario;
	private String formato;
	private int numPaginas;
	private Date dataPublicacao;
	private String titulo;

	@Override
	public String toString() {
		return "ISBN: " + isbn + "\n" + "Editora: " + "\n" + editora + "\n" + "Título: " + titulo + "\n"
				+ "Resumo livro: " + resumoLivro + "\n" + "Sumário: " + sumario + "\n" + "Formato: " + formato + "\n"
				+ "Número de páginas" + numPaginas + "\n" + "Data de publicação: " + dataPublicacao + "\r\n";
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Column(name = "autor")
	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

	@Column(name = "editora", length = 50)
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Column(name = "resumo_livro", length = 250)
	public String getResumoLivro() {
		return resumoLivro;
	}

	public void setResumoLivro(String resumoLivro) {
		this.resumoLivro = resumoLivro;
	}

	@Column(name = "sumario")
	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	@Column(name = "formato")
	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Column(name = "num_paginas")
	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Column(name = "data_publicacao")
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

}
