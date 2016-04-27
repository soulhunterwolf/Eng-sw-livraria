
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.UsuarioInterno;

public interface IUsuarioInternoDao {
	
	public void adicionar(UsuarioInterno ui);
	public void remover(String nome) ;
	public void atualizar(String nome, UsuarioInterno a);
	// métodos de pesquisas do UsuarioInterno
	public List<UsuarioInterno> pesquisaTodos();
	public List<UsuarioInterno> pesquisaPorNome(String nome);
	public List<UsuarioInterno> pesquisaPorIdentificacao(int identificacao);
}

