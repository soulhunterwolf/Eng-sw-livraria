
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.Cliente;

public interface IClienteDao {
	
	public void adicionar(Cliente a);
	public void remover(String nome) ;
	public void atualizar(String nome, Cliente a);
	// métodos de pesquisas do Cliente
	public List<Cliente> pesquisaTodos();
	public List<Cliente> pesquisaPorNome(String nome);
}

