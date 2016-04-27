
package fatec.edu.dao;

import java.util.List;

import fatec.edu.entidades.Autor;
import fatec.edu.entidades.Cliente;

public interface IRelatorioDao {
	
	public List<Autor> relatorioAutorMaisVendido();
	public int relatorioQtdMaisVendido();
	public List<Cliente> relatorioClienteMaisFreq();
}

