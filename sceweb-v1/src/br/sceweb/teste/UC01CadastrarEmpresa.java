package br.sceweb.teste;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {

	static public EmpresaDAO empresaDAO;
	static public Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		
		empresa.setCnpj("89424232000180");
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		
	}

	@Test
	public void CT01UC01FBCadastrarEmpresa_com_sucesso() {
		empresaDAO.exclui(empresa);
		assertEquals(1, empresaDAO.adiciona(empresa));
		empresaDAO.exclui(empresa);
			
	}
	
	@Test(expected = RuntimeException.class)
	public void CT02UC01A2_Cadastra_empresa_cnpj_ja_cadastrado(){
		empresaDAO.adiciona(empresa);
		empresaDAO.adiciona(empresa);
	}

	@Test
	public void CT03UC01A3_Cadastra_empresa_cnpj_invalido(){
		Empresa empresa2 = new Empresa();
		try{
			empresa2.setCnpj("8942423200018");
			fail("deveria disparar uma exception");
		}catch(Exception e){
			assertEquals("CNPJ inválido!", e.getMessage());
		}
	}

	@Test
	public void CT04UC01A4_Cadastra_empresa_com_dados_ivalidos(){
		Empresa empresa2 = new Empresa();
		try{
			empresa.setNomeDaEmpresa("");
			fail("deveria disparar uma exception");
		}catch(Exception e ){
			
		}
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui(empresa);
	}
}

