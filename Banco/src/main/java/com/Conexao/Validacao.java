package com.Conexao;

import java.math.BigDecimal;
import java.sql.Statement;

public class Validacao {
	private static String contaAtual;
	private static String contaDestino;
	
	private static BigDecimal statusContaAtual;
	private static BigDecimal statusContaDestino;
	
	//Getters e Setters
//-------------------------------------------------
	
	public static String getContaAtual() {
		return contaAtual;
	}

	public static void setContaAtual(String contaAtual) {
		Validacao.contaAtual = contaAtual;
	}
	

	public static Double getStatusContaAtual() {
		return statusContaAtual.doubleValue();
	}

	public static void setStatusContaAtual(Double statusContaAtual) {
		Validacao.statusContaAtual = new BigDecimal(statusContaAtual);
	}

	public static Double getStatusContaDestino() {
		return statusContaDestino.doubleValue();
	}

	public static void setStatusContaDestino(Double statusContaDestino) {
		Validacao.statusContaDestino = new BigDecimal(statusContaDestino);
	}

	public static String getContaDestino() {
		return contaDestino;
	}

	public static void setContaDestino(String contaDestino) {
		Validacao.contaDestino = contaDestino;
	}

	//Metodos
//----------------------------------------------------
	
	public static boolean validacaoConta(String com,String linha) {
		String dado=BancoDados.infoUsuarioString(com,linha);
		if (dado!=null && contaAtual==null) {
			contaAtual=dado;
			return true;
		}
		if (contaAtual!=null && dado!=null) {
			contaDestino=dado;
			return true;
		}
		return false;
	}
	
		
//------------------------------------------------------
	public static String validaDado(String coluna,String linha) {
		String dado=BancoDados.infoUsuarioString(coluna,linha);
		if (dado!=null) {
			return dado;
		}
		return null;
	}
	
//	public static void atualizaSaldoDB() {
//		
//	}
	

}
