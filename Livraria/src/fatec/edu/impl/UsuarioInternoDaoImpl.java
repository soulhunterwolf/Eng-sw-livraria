package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.IUsuarioInternoDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.UsuarioInterno;

public class UsuarioInternoDaoImpl implements IUsuarioInternoDao {

	@Override
	public void adicionar(UsuarioInterno ui) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(ui);
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
			UsuarioInterno ui = em.find(UsuarioInterno.class, nome);
			em.getTransaction().begin();
			em.remove(ui);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void atualizar(String nome, UsuarioInterno ui) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			ui = em.find(UsuarioInterno.class, nome);
			em.getTransaction().begin();
			em.merge(ui);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UsuarioInterno> pesquisaTodos() {
		List<UsuarioInterno> listaUsuarioInterno;
		listaUsuarioInterno = new ArrayList<UsuarioInterno>();
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "select u from UsuarioInterno u";
			TypedQuery<UsuarioInterno> qry = em.createQuery(sql, UsuarioInterno.class);
			listaUsuarioInterno = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaUsuarioInterno;

	}

	@Override
	public List<UsuarioInterno> pesquisaPorNome(String nome) {
		List<UsuarioInterno> listaUIPorNome = new ArrayList<UsuarioInterno>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT u FROM UsuarioInterno u WHERE u.nome = :nome";
			TypedQuery<UsuarioInterno> qry = em.createQuery(sql, UsuarioInterno.class);
			qry.setParameter("nome", nome);
			listaUIPorNome = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaUIPorNome;
}

	@Override
	public List<UsuarioInterno> pesquisaPorIdentificacao(int identificacao) {
		List<UsuarioInterno> listaUIPorIdentificacao = new ArrayList<UsuarioInterno>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT u FROM UsuarioInterno u WHERE u.identificacao = :identificacao";
			TypedQuery<UsuarioInterno> qry = em.createQuery(sql, UsuarioInterno.class);
			qry.setParameter("identificacao", identificacao);
			listaUIPorIdentificacao = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaUIPorIdentificacao;
	}

}
