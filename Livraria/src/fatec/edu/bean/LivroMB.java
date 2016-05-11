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
	private String nomeAutorDois;
	private String nomeAutorTres;
	private String nomeAutorQuatro;
	private String nomeAutorCinco;
	private List<SelectItem> descFormato = new ArrayList<SelectItem>();
	private int codigoFormato;
	private String tituloFiltro;
	private String filtroEditora;
	private String categoriaFiltro;
	private String autorFiltro;
	private int isbnFiltro;
	private List<Livro> carrinho = new ArrayList<Livro>();
	private int filtroCarrinho;

	public LivroMB() {
		livroDao = new LivroDaoImpl();
		livros = new ArrayList<Livro>();
		livroAtual = new Livro();
		tituloFiltro = "";
	}

	public List<Livro> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Livro> carrinho) {
		this.carrinho = carrinho;
	}

	public int getFiltroCarrinho() {
		return filtroCarrinho;
	}

	public void setFiltroCarrinho(int filtroCarrinho) {
		this.filtroCarrinho = filtroCarrinho;
	}

	public String getCategoriaFiltro() {
		return categoriaFiltro;
	}

	public void setCategoriaFiltro(String categoriaFiltro) {
		this.categoriaFiltro = categoriaFiltro;
	}

	public String getAutorFiltro() {
		return autorFiltro;
	}

	public void setAutorFiltro(String autorFiltro) {
		this.autorFiltro = autorFiltro;
	}

	public String getFiltroEditora() {
		return filtroEditora;
	}

	public void setFiltroEditora(String filtroEditora) {
		this.filtroEditora = filtroEditora;
	}

	public String getNomeAutorDois() {
		return nomeAutorDois;
	}

	public void setNomeAutorDois(String nomeAutorDois) {
		this.nomeAutorDois = nomeAutorDois;
	}

	public String getNomeAutorTres() {
		return nomeAutorTres;
	}

	public void setNomeAutorTres(String nomeAutorTres) {
		this.nomeAutorTres = nomeAutorTres;
	}

	public String getNomeAutorQuatro() {
		return nomeAutorQuatro;
	}

	public void setNomeAutorQuatro(String nomeAutorQuatro) {
		this.nomeAutorQuatro = nomeAutorQuatro;
	}

	public String getNomeAutorCinco() {
		return nomeAutorCinco;
	}

	public void setNomeAutorCinco(String nomeAutorCinco) {
		this.nomeAutorCinco = nomeAutorCinco;
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

	public String cancelar() {
		return "index.xhtml";
	}

	public String adicionar(Livro l) {
		String msg = "Erro ao adicionar produto";
		String retorno = "./insertlivro.xhtml";

		try {

			List<Autor> autores = new ArrayList<>();
			Autor autor = new Autor();

			autor.setNome(this.nomeAutor);
			autores.add(autor);
			autor.setNome(this.nomeAutorDois);
			autores.add(autor);
			autor.setNome(this.nomeAutorTres);
			autores.add(autor);
			autor.setNome(this.nomeAutorQuatro);
			autores.add(autor);
			autor.setNome(this.nomeAutorCinco);
			autores.add(autor);

			livroAtual.setFormato(FormatosEnum.getFormatoBrochuraEnum(this.codigoFormato).toString());
			this.livroAtual.setAutor(autores);
			livroDao.adicionar(livroAtual);
			msg = "Livro adicionado com sucesso!";
			System.out.println("Gravando o livro: ");
			System.out.println("Autores: " + "\n" + this.livroAtual.getAutor().toString() + "\n");
			System.out.println(livroAtual.toString());
			livroAtual = new Livro();
			this.nomeAutor = "";
			this.nomeAutorDois = "";
			this.nomeAutorTres = "";
			this.nomeAutorQuatro = "";
			this.nomeAutorCinco = "";
		} catch (Exception e) {
			e.printStackTrace();
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

		return retorno;
	}

	public String removerLivro(int isbn) {
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

	public String procurarAlterar() {
		String retorno = "updatelivro.xhtml";
		try {
			int isbn = isbnFiltro;
			livros = livroDao.pesquisaPorIsbn(isbn);
			livroAtual = livros.get(0);

			nomeAutor = livroAtual.getAutor().get(0).getNome();
			nomeAutorDois = livroAtual.getAutor().get(1).getNome();
			nomeAutorTres = livroAtual.getAutor().get(2).getNome();
			nomeAutorQuatro = livroAtual.getAutor().get(3).getNome();
			nomeAutorCinco = livroAtual.getAutor().get(4).getNome();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public String alterar(int isbn) {
		String msg = "Produto atualizado com sucesso!";
		String retorno = "./updatelivro.xhtml";

		try {

			List<Autor> autores = new ArrayList<>();
			Autor autor = new Autor();

			autor.setNome(this.nomeAutor);
			autores.add(autor);
			autor.setNome(this.nomeAutorDois);
			autores.add(autor);
			autor.setNome(this.nomeAutorTres);
			autores.add(autor);
			autor.setNome(this.nomeAutorQuatro);
			autores.add(autor);
			autor.setNome(this.nomeAutorCinco);
			autores.add(autor);

			livroAtual.setFormato(FormatosEnum.getFormatoBrochuraEnum(this.codigoFormato).toString());
			this.livroAtual.setAutor(autores);
			livroDao.atualizar(isbn, livroAtual);
			livros = new ArrayList<Livro>();
			livroAtual = new Livro();
			isbnFiltro = 0;
			this.nomeAutor = "";
			this.nomeAutorDois = "";
			this.nomeAutorTres = "";
			this.nomeAutorQuatro = "";
			this.nomeAutorCinco = "";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao atualizar o produto!";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

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

	public void pesquisarPorIsbn(int isbn) {
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

	public void pesquisarPorEditora(String editora) {
		String msg = "Todos os livros pesquisados!";

		try {
			editora = filtroEditora;
			livros = livroDao.pesquisaPorEditora(editora);

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}

	public void adicionarCarrinho(int isbn) {

		isbn = isbnFiltro;

		try {
			livros = livroDao.pesquisaPorIsbn(isbn);

			carrinho.add(livros.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removerDoCarrinho(int isbn) {

		try {
			livros = livroDao.pesquisaPorIsbn(isbn);

			carrinho.remove(isbn);
			
			for(int i=0; i < carrinho.size(); i++){
				if(carrinho.get(i).getIsbn() == isbn){
					carrinho.remove(carrinho.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pesquisarPorCategoria(String categoria) {
		String msg = "Erro ao consultar livro";

		try {
			categoria = categoriaFiltro;
			livros = livroDao.pesquisaPorCategoria(categoria);

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao consultar livros";
		}

		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("", new FacesMessage(msg));

	}
}
