
package fatec.edu.dao;

import fatec.edu.entidades.Livro;

public interface IEstoqueDao {
	
	public void adicionarLivroAoEstoque(Livro l, int quantidade);
	public void retirarLivroDoEstoque(int isbn);

}

