
package fatec.edu.dao;

public interface IPagamentoDao {
	
	public void efetuarPagamento();
	public void registrarVenda(double total);
	public void removerProdutoEstoque();
}

