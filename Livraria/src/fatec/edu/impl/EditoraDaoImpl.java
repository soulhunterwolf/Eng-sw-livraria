package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IEditoraDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Editora;

public class EditoraDaoImpl implements IEditoraDao {

	@Override
	public void adicionar(Editora e) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		
	}

	@Override
	public void atualizar(String nome, Editora e) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			e = em.find(Editora.class, nome);
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void remover(String nome) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			Editora e = em.find(Editora.class, nome);
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public List<Editora> pesquisaTodos() {
		List<Editora> listaEditoras;
		listaEditoras = new ArrayList<Editora>();
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "select e from Editora e";
			TypedQuery<Editora> qry = em.createQuery(sql, Editora.class);
			listaEditoras = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaEditoras;

	}

	@Override
	public List<Editora> pesquisaPorNome(String nome) {
		List<Editora> listaEditoraPorNome = new ArrayList<Editora>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT e FROM Editora e WHERE e.nome = :nome";
			TypedQuery<Editora> qry = em.createQuery(sql, Editora.class);
			qry.setParameter("nome", nome);
			listaEditoraPorNome = qry.getResultList();
			em.close();
		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return listaEditoraPorNome;
	}

}
