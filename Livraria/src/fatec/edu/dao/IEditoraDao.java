
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.Editora;

public interface IEditoraDao {
	
	public void adicionar(Editora a);
	public void remover(String nome) ;
	public void atualizar(String nome, Editora a);
	// m�todos de pesquisas do Editora
	public List<Editora> pesquisaTodos();
	public List<Editora> pesquisaPorNome(String nome);
}

