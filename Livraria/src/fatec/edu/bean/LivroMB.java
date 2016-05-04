package fatec.edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import fatec.edu.dao.ILivroDao;
import fatec.edu.entidades.Autor;
import fatec.edu.entidades.FormatosEnum;
import fatec.edu.entidades.Livro;
import fatec.edu.impl.LivroDaoImpl;

@ManagedBean(name = "livroMB")
@SessionScoped
public class LivroMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Livro livroAtual;
	private ILivroDao livroDao;
	private List<Livro> livros;
	private String nomeAutor;
	private List<SelectItem> descFormato = new ArrayList<SelectItem>();
	private int codigoFormato;
	private String tituloFiltro;
	private int isbnFiltro;

	public LivroMB() {
		livroDao = new LivroDaoImpl();
		livros = new ArrayList<Livro>();
		livroAtual = new Livro();
		tituloFiltro = "";
	}

	public int getIsbnFiltro() {
		return isbnFiltro;
	}

	public void setIsbnFiltro(int isbnFiltro) {
		this.isbnFiltro = isbnFiltro;
	}

	public String getTituloFiltro() {
		return tituloFiltro;
	}

	public void setTituloFiltro(String tituloFiltro) {
		this.tituloFiltro = tituloFiltro;
	}

	public List<SelectItem> getDescFormato() {
		return descFormato;
	}

	public void setDescFormato(List<SelectItem> descFormato) {
		this.descFormato = descFormato;
	}

	public int getCodigoFormato() {
		return codigoFormato;
	}

	public void setCodigoFormato(int codigoFormato) {
		this.codigoFormato = codigoFormato;
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

	@PostConstruct
	public void init() {
		for (FormatosEnum value : FormatosEnum.values()) {
			this.descFormato.add(new SelectItem(value.getCodigoFormato(), value.getDescFormato()));
		}
	}
	
	public String cancelar(){
		return "index.xhtml";
	}
	
	public String adicionar(Livro l) {
		String msg = "Erro ao adicionar produto";
		String retorno = "./insertlivro.xhtml";

		try {

			List<Autor> autores = new ArrayList<>();
			Autor autor = new Autor();
			
			for(int i = 0; i == autores.size(); i++){
				autor.setNome(this.nomeAutor);
				autores.add(autor);
				this.nomeAutor = "";
			}
			
			livroAtual.setFormato(FormatosEnum.getFormatoBrochuraEnum(this.codigoFormato).toString());
			this.livroAtual.setAutor(autores);
			livroDao.adicionar(livroAtual);
			msg = "Livro adicionado com sucesso!";
			System.out.println("Gravando o livro: ");
			System.out.println("Autores: " + "\n" + this.livroAtual.getAutor().toString() + "\n");
			System.out.println(livroAtual.toString());
			livroAtual = new Livro();
		} catch (Exception e) {
			e.printStackTrace();
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

		return retorno;
	}
	
	public String removerLivro(int isbn){
		String retorno = "removelivro.xhtml";
		String msg = "Livro removido com sucesso!";
		
		try {
			livroDao.remover(isbn);
			livros = new ArrayList<Livro>();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao remover livro";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));
		
		return retorno;
	}
	
	public String procurarAlterar(int isbn){
		String retorno = "updatelivro.xhtml";
		livroAtual = livroDao.pesquisaPorIsbn(isbn).get(0);
		
		return retorno;
	}

	public void pesquisarTodos() {
		String msg = "Erro ao consultar livro";

		try {
			livros = livroDao.pesquisaTodos();
			msg = "Todos os livros pesquisados!";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
	
	public void pesquisarPorIsbn(int isbn){
		String msg = "Livro encontrado!";

		try {
			livros = livroDao.pesquisaPorIsbn(isbn);
						
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));
	}
	
	public void pesquisarPorTitulo(String titulo) {
		String msg = "Erro ao consultar livro";

		try {
			livros = livroDao.pesquisaPorTitulo(titulo);
			msg = "Todos os livros pesquisados!";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
	
	public void pesquisarPorAutor() {
		String msg = "Erro ao consultar livro";

		try {
			livros = livroDao.pesquisaTodos();
			msg = "Todos os livros pesquisados!";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
	
	public void pesquisarPorEditora() {
		String msg = "Erro ao consultar livro";

		try {
			livros = livroDao.pesquisaTodos();
			msg = "Todos os livros pesquisados!";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
	
	public void pesquisarPorCategoria() {
		String msg = "Erro ao consultar livro";

		try {
			livros = livroDao.pesquisaTodos();
			msg = "Todos os livros pesquisados!";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
}
