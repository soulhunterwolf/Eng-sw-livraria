package fatec.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.entidades.Livro;

public class LivroDaoImpl implements ILivroDao {

	@Override
	public void adicionar(Livro l) {

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void remover(int isbn) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			Livro l = em.find(Livro.class, isbn);
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(int isbn, Livro l) {
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			l = em.find(Livro.class, isbn);
			em.getTransaction().begin();
			em.merge(l);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Livro> pesquisaTodos() {
		List<Livro> listaLivros;
		listaLivros = new ArrayList<Livro>();
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELEC l FROM Livro l ";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			listaLivros = qry.getResultList();
			em.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}		
		return listaLivros;
	}

	@Override
	public List<Livro> pesquisaPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> pesquisaPorAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> pesquisaPorEditora(String editora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> pesquisaPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}

