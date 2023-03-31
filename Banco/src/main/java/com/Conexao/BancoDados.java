package com.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BancoDados {
	
	private static String url="jdbc:mysql://localhost:3306/cadastros";
	private static String user="lazaro";
	private static String password="1234";
    private static String tabela="pessoas_jdbc";
	
	public static String getTabela() {
		return tabela;
	}

	public static void setTabela(String tabela) {
		BancoDados.tabela = tabela;
	}

	private static Connection conexao;
	private static Statement state;
	/*public BancoDados(String url, String user, String password) {
		this.url=url;
		this.user=user;
		this.password=password;
	}*/
	
	public static void criarBanco() {
		try {
			conexao=DriverManager.getConnection(url, user , password);
		    state=conexao.createStatement();		    
		    
		
		} catch (SQLException e) {
			System.out.println("falha ao se conectar ao banco de dados");
			e.printStackTrace();
		}
		
	}
	
//---------------------------------------------------------------------------
	
	public static String infoUsuarioString(String com, String coluna) {
		try {
			
			ResultSet result=state.executeQuery(com);
			String dado=null;
			
			while(result.next()) {
				dado=result.getString(coluna);}
			//String dados=result.getString(coluna);
			//String dados=result.getString(dado);
			//conexao.close();
			return dado;
		} catch (SQLException e) {
			System.out.println("Dado não encontrado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

//-----------------------------------------------------------------------	
	
	public static Double InfoUsuarioNum(String com, String linha) {
		try {
			
			ResultSet result=state.executeQuery(com);
			Double dados=null;
			while(result.next()) {
			dados=result.getDouble(linha);
			}
			return dados;
		} catch (SQLException e) {
			System.out.println("Dado não encontrado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
//--------------------------------------------------------------------------
	
	public static boolean setUsuarioSaldo(String pessoa, Double valor) {
		try {
			
		//ResultSet result=state.getResultSet();
			state.executeUpdate("update "+tabela+" set saldo="+valor+" where nome='"+pessoa+"';");
			//result.updateDouble("nome="+pessoa, valor);
			return true;
		} catch (SQLException e) {
			System.out.println("Dado não encontrado");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
				
	}
	

	
//----------------------------------------------------
	
	//public static Statement getState() {
	//	return state;
	//}

	//public static void setState(Statement state) {
	//	BancoDados.state = state;
	//}
//----------------------------------------------------	
	
}
