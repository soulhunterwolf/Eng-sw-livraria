package fatec.edu.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fatec.edu.dao.ILivroDao;
import fatec.edu.dao.JPAUtil;
import fatec.edu.entidades.Autor;
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
			String sql = "select l from Livro l";
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
		List<Livro> listaLivrosPorTitulo = new ArrayList<Livro>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT l FROM Livro l WHERE l.titulo LIKE :titulo";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			qry.setParameter("titulo", "%" + titulo + "%");
			listaLivrosPorTitulo = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaLivrosPorTitulo;
	}
	
	public List<Autor> populaAutor(){
		List<Autor> listaPopulaAutor = new ArrayList<Autor>();
		
		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT `autor_id` from `livro_autor` inner join `livro` on `livro`.`isbn` = `livro_autor`.`livro_id`";
			TypedQuery<Autor> qry = em.createQuery(sql, Autor.class);
			listaPopulaAutor = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return listaPopulaAutor;
	}
	
	@Override
	public List<Livro> pesquisaPorAutor(String autor) {
		List<Livro> listaLivrosPorAutor = new ArrayList<Livro>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELEC l FROM Livro l WHERE l.autor = :autor";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			qry.setParameter("autor", autor);
			listaLivrosPorAutor = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaLivrosPorAutor;
	}

	@Override
	public List<Livro> pesquisaPorEditora(String editora) {
		List<Livro> listaLivrosPorEditora = new ArrayList<Livro>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELEC l FROM Livro l WHERE l.editora = :editora";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			qry.setParameter("editora", editora);
			listaLivrosPorEditora = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaLivrosPorEditora;
	}

	@Override
	public List<Livro> pesquisaPorCategoria(String categoria) {
		List<Livro> listaLivrosPorCategoria = new ArrayList<Livro>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELEC l FROM Livro l WHERE l.categoria = :categoria";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			qry.setParameter("categoria", categoria);
			listaLivrosPorCategoria = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaLivrosPorCategoria;
	}

	@Override
	public List<Livro> pesquisaPorIsbn(int isbn) {
		
		List<Livro> listaLivrosPorIsbn = new ArrayList<Livro>();

		try {
			EntityManager em = JPAUtil.getInstance().getEMF().createEntityManager();
			String sql = "SELECT l FROM Livro l WHERE l.isbn = :isbn";
			TypedQuery<Livro> qry = em.createQuery(sql, Livro.class);
			qry.setParameter("isbn", isbn);
			listaLivrosPorIsbn = qry.getResultList();
			em.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return listaLivrosPorIsbn;
	}

}
