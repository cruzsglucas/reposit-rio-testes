package br.sceweb.servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class FabricaDeConexoes {

	public Connection getConnection(){
		String url = "jdbc:mysql://localhost/sceweb";
		try{

			return DriverManager.getConnection(url,	"root", "aluno");

		
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}


}
