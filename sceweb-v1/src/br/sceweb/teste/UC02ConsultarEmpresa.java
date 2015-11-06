package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static public EmpresaDAO empresaDAO;
	static public Empresa empresa;
	static public Empresa empresa2;
	


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();

		empresa.setCnpj("89424232000180");
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		
		empresaDAO.adiciona(empresa);
		
	}

	@Test
	public void CT01UC02FBConsultarEmpresa_com_sucesso() {
		assertTrue(empresa.equals(empresaDAO.consultaEmpresas("89424232000180")));
	}


	@Test
	public void CT02UC02FBConsultarEmpresas_com_sucesso() {
		empresa2 = new Empresa();
		
		empresa2.setNomeDaEmpresa("empresa x");
		empresa2.setCnpj("76866310000155");
		empresa2.setNomeFantasia("empresa x");
		empresa2.setTelefone("2222");
		empresa2.setEndereco("rua taquari");
		
		empresaDAO.adiciona(empresa2);
		
		assertEquals(2,  empresaDAO.consultaEmpresas().size());
		
		empresaDAO.exclui(empresa2.getCnpj());

	}



	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui(empresa.getCnpj());
	}


}
