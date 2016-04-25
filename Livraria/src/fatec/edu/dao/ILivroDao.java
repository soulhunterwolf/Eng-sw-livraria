package fatec.edu.dao;


import java.util.List;

import fatec.edu.entidades.Livro;

public interface ILivroDao {
	
	public void adicionar(Livro l);
	public void remover(int isbn) ;
	public void atualizar(int isbn, Livro l);
	// métodos de pesquisas por título, autor, editora ou categoria do livro
	public List<Livro> pesquisaTodos();
	public List<Livro> pesquisaPorTitulo(String titulo);
	public List<Livro> pesquisaPorAutor(String autor);
	public List<Livro> pesquisaPorEditora(String editora);
	public List<Livro> pesquisaPorCategoria(String categoria);
}
