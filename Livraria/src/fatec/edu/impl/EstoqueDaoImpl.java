package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IEstoqueDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Estoque;
import fatec.edu.entidades.Livro;


public class EstoqueDaoImpl implements IEstoqueDao {

	@Override
	public void adicionarLivroAoEstoque(Livro l, int quantidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirarLivroDoEstoque(int isbn) {
		// TODO Auto-generated method stub
		
	}

}
