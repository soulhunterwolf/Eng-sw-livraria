package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IRelatorioDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Autor;
import fatec.edu.entidades.Cliente;

public class RelatorioDaoImpl implements IRelatorioDao {

	@Override
	public List<Autor> relatorioAutorMaisVendido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int relatorioQtdMaisVendido() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cliente> relatorioClienteMaisFreq() {
		// TODO Auto-generated method stub
		return null;
	}

}
