
package fatec.edu.dao;

import java.util.List;

import org.primefaces.component.editor.Editor;

import fatec.edu.entidades.Autor;
import fatec.edu.entidades.Livro;

public interface IPesquisaDao {
	
	public List<Autor> pesquisaAutorMaisPesquisado();
	public List<Livro> livroMaisPesquisado();
	public List<Editor> editoraMaisPesquisada();

}

