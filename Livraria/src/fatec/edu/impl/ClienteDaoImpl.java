package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IClienteDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Cliente;

public class ClienteDaoImpl implements IClienteDao {

	@Override
	public void adicionar(Cliente c) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void remover(String nome) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			Cliente c = em.find(Cliente.class, nome);
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void atualizar(String nome, Cliente c) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			c = em.find(Cliente.class, nome);
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Cliente> pesquisaTodos() {
		List<Cliente> listaClientes;
		listaClientes = new ArrayList<Cliente>();
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "select c from Cliente c";
			TypedQuery<Cliente> qry = em.createQuery(sql, Cliente.class);
			listaClientes = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaClientes;
}

	@Override
	public List<Cliente> pesquisaPorNome(String nome) {
		List<Cliente> listaClientesPorNome = new ArrayList<Cliente>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
			TypedQuery<Cliente> qry = em.createQuery(sql, Cliente.class);
			qry.setParameter("nome", nome);
			listaClientesPorNome = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaClientesPorNome;

	}

}
