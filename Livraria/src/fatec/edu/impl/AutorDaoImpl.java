package fatec.edu.impl;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IAutorDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Autor;


public class AutorDaoImpl implements IAutorDao {

	@Override
	public void adicionar(Autor a) {
		
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(a);
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
			Autor a = em.find(Autor.class, nome);
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void atualizar(String nome, Autor a) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			a = em.find(Autor.class, nome);
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Autor> pesquisaTodos() {
		List<Autor> listaAutores;
		listaAutores = new ArrayList<Autor>();
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "select a from Autor a";
			TypedQuery<Autor> qry = em.createQuery(sql, Autor.class);
			listaAutores = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaAutores;
	}

	@Override
	public List<Autor> pesquisaPorNome(String nome) {
		List<Autor> listaAutoresPorNome = new ArrayList<Autor>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT a FROM Autor a WHERE a.nome = :nome";
			TypedQuery<Autor> qry = em.createQuery(sql, Autor.class);
			qry.setParameter("nome", nome);
			listaAutoresPorNome = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaAutoresPorNome;

	}

}
