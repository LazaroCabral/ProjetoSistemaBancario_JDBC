package Banco;

import java.util.Scanner;

import com.Conexao.BancoDados;
import com.Conexao.Validacao;

public class Tela {

public static void main(String[] args){
	BancoDados.criarBanco();
    verifica();
   }


public static void verifica(){
	boolean repeat=true;
	while(repeat) {
		Scanner input=new Scanner(System.in);
		System.out.println("digite o nome da conta");
		String escolha;
		try {
			escolha=input.next();
		}catch(java.util.InputMismatchException e) {
  	    	continue;
  	    }
		boolean resultado=Validacao.validacaoConta("select nome from "+BancoDados.getTabela()+" where nome= '"+escolha+"';","nome");
	    
		if(resultado==true){
			Validacao.setStatusContaAtual(BancoDados.InfoUsuarioNum("select saldo from "+BancoDados.getTabela()+" where nome='"+Validacao.getContaAtual()+"';", "saldo"));
			System.out.println("\nbem vindo "+Validacao.getContaAtual()+"\n");
			escolha();
			continue;
		}
		
		if (resultado==false){
			System.out.println("conta nao encontrada\n1 escolher conta\n2 sair");
			Scanner input2=new Scanner(System.in);
			int escolha2;
			try {
				escolha2=input2.nextInt();
			}catch(java.util.InputMismatchException e) {
	  	    	continue;
	  	    }
			switch(escolha2){
				case 1: continue;
				case 2:
					System.out.println("até logo \n:)");
					try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				    System.out.println(";)");
				    repeat=false;
			        System.exit(0);
				default : continue;
			}
				
			}
		}
	
}

public static void escolha(){
	boolean repeat=true;
	while(repeat) {
		System.out.println("escolha uma opçao\n1 transferir\n2 sacar\n3 verificar status da conta\n4 trocar de conta\n5 sair");
		Scanner input= new Scanner(System.in);
		int escolha;
		try {
			escolha=input.nextInt();
		}catch(java.util.InputMismatchException e) {
  	    	continue;
  	    }
		switch(escolha){
		        case 1: Escolhas.transferencia();
		        continue;
		        case 2: Escolhas.sacar();
		        continue;
		        case 3: Escolhas.status();
		        continue;
		        case 4: 
		        Validacao.setContaAtual(null);
		        Validacao.setContaDestino(null);
		        
		        Validacao.setStatusContaAtual((double) 0);
		        Validacao.setStatusContaDestino((double) 0);
		        repeat=false;
		        continue;
		        case 5: System.out.println("até logo \n:)");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    System.out.println(";)");
		        System.exit(0);
		 
			default : continue;
		}
	}
	}

}