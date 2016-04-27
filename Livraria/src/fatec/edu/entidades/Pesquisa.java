package fatec.edu.entidades;

import java.util.List;

public class Pesquisa {

	private List<Autor> autorMaisPesquisado;
	private List<Livro> livrosMaisPesquisados;
	private List<Editora> editoraMaisPesquisada;
	
	public List<Autor> getAutorMaisPesquisado() {
		return autorMaisPesquisado;
	}
	public void setAutorMaisPesquisado(List<Autor> autorMaisPesquisado) {
		this.autorMaisPesquisado = autorMaisPesquisado;
	}
	public List<Livro> getLivrosMaisPesquisados() {
		return livrosMaisPesquisados;
	}
	public void setLivrosMaisPesquisados(List<Livro> livrosMaisPesquisados) {
		this.livrosMaisPesquisados = livrosMaisPesquisados;
	}
	public List<Editora> getEditoraMaisPesquisada() {
		return editoraMaisPesquisada;
	}
	public void setEditoraMaisPesquisada(List<Editora> editoraMaisPesquisada) {
		this.editoraMaisPesquisada = editoraMaisPesquisada;
	}
	
	public String calcularAutorMaisPesquisado(){
		return null;
	}
	
	public List<Livro> calcularLivrosMaisPesquisados(){
		return null;
	}
	
	public String calcularEditoraMaisPesquisada(){
		return null;
	}
}
