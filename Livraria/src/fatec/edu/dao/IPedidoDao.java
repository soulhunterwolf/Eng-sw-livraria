
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.Pedido;

public interface IPedidoDao {
	
	public void adicionar(Pedido p);
	public void remover(int numero) ;
	public void atualizar(int numero, Pedido p);
	// métodos de pesquisas do Pedido
	public List<Pedido> pesquisaTodos();
	public List<Pedido> pesquisaPorNumero(int numero);
}

