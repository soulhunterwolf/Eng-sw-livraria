package fatec.edu.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Autor")
public class Autor {
	@Id
	private String nome;
	private Date dataNasc;
	private Date dataMorte;
	private String localNasc;
	private String localMorte;
	private String biografia;

	@ManyToMany(mappedBy="autor")
	private List<Livro> livros;
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public String getLocalNasc() {
		return localNasc;
	}

	public void setLocalNasc(String localNasc) {
		this.localNasc = localNasc;
	}

	public String getLocalMorte() {
		return localMorte;
	}

	public void setLocalMorte(String localMorte) {
		this.localMorte = localMorte;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void addAutor() {

	}
	
	@Override
	public String toString(){
		return "Nome(s) do(s) autor(es): " + nome;
	}
	
	public static int calcIdade(Date dataNascimento, Date dataAtualOuMorte) {
		int idade = 0;
		return idade;
	}
}
