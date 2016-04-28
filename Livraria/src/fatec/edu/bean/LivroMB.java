package fatec.edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fatec.edu.dao.ILivroDao;
import fatec.edu.entidades.Autor;
import fatec.edu.entidades.FormatosEnum;
import fatec.edu.entidades.Livro;
import fatec.edu.impl.LivroDaoImpl;

@ManagedBean(name ="livroMB")
@SessionScoped
public class LivroMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Livro livroAtual;
	private ILivroDao livroDao;
	private List<Livro> livros;
	private String nomeAutor;

	public LivroMB() {
		livroDao = new LivroDaoImpl();
		livros = new ArrayList<Livro>();
		livroAtual = new Livro();
	}

	public Livro getLivroAtual() {
		return livroAtual;
	}

	public void setLivroAtual(Livro livroAtual) {
		this.livroAtual = livroAtual;
	}

	public ILivroDao getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(ILivroDao livroDao) {
		this.livroDao = livroDao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	public FormatosEnum[] getFormatos(){
		return FormatosEnum.values();
	}
	public String adicionar(Livro l) {
		String msg = "Erro ao adicionar produto";
		String retorno = "./insertlivro.xhtml";

		try {

			List<Autor> autores = new ArrayList<>();
			Autor autor = new Autor();
			autor.setNome(this.nomeAutor);
			autores.add(autor);

			this.livroAtual.setAutor(autores);

			livroDao.adicionar(livroAtual);
			msg = "Livro adicionado com sucesso!";
			System.out.println("Gravando o livro: " + "\n" + this.livroAtual.getIsbn() + "\n"
					+ this.livroAtual.getTitulo() + "\n" + this.livroAtual.getAutor() + "\n"
					+ this.livroAtual.getEditora() + "\n" + this.livroAtual.getResumoLivro() + "\n"
					+ this.livroAtual.getSumario() + "\n" + this.livroAtual.getFormato() + "\n"
					+ this.livroAtual.getNumPaginas() + "\n" + this.livroAtual.getDataPublicacao());
			livroAtual = new Livro();
			nomeAutor = "";
		} catch (Exception e) {
			e.printStackTrace();
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

		return retorno;
	}
}
