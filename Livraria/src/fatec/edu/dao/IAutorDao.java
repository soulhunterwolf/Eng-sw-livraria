
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.Autor;

public interface IAutorDao {
	
	public void adicionar(Autor a);
	public void remover(String nome) ;
	public void atualizar(String nome, Autor a);
	// métodos de pesquisas do Autor
	public List<Autor> pesquisaTodos();
	public List<Autor> pesquisaPorNome(String nome);
}

