
package Banco;
import static Banco.Tela.escolha;
import static Banco.Tela.verifica;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.Conexao.BancoDados;
import com.Conexao.Validacao;
public class Escolhas{
 
public static void transferencia(){
	boolean repeat=true;
	while(repeat) {
	    System.out.println("status da conta R$ "+Validacao.getStatusContaAtual()+"\ndigite para quem deseja transferir");
	    Scanner input=new Scanner(System.in);
	    String pessoa=null;
	    try {
	    	pessoa=input.next();
	    }catch(java.util.InputMismatchException e) {
	    	continue;
	    }
	    if(pessoa.equals(Validacao.getContaAtual())){
	    	System.out.println("você não pode transferir para si mesmo");
	    	continue;
	    }
	    boolean result=Validacao.validacaoConta("select nome from "+BancoDados.getTabela()+" where nome='"+pessoa+"';","nome");
	   
	    
	      if(result){
	    	  Validacao.setStatusContaDestino(BancoDados.InfoUsuarioNum("select saldo from "+BancoDados.getTabela()+" where nome='"+pessoa+"';", "saldo"));
	            
	          System.out.println(Validacao.getContaDestino()+" selecionado\n");
	          System.out.println("status conta de destino R$ "+Validacao.getStatusContaDestino());
	          System.out.println("digite o valor que deseja transferir");
	          Scanner input2=new Scanner(System.in);
	          Double valor=null;
	          try {
	        	  valor=input2.nextDouble();
	          }catch(java.util.InputMismatchException e) {
	  	    	continue;
	  	    }
	            
	           
	            if (Validacao.getStatusContaAtual()>0 && Validacao.getStatusContaAtual()>=valor) {
	                 
	                 Validacao.setStatusContaAtual(Validacao.getStatusContaAtual()-valor);
	                 Validacao.setStatusContaDestino(Validacao.getStatusContaDestino()+valor);
	                 
	                 
	                 if (BancoDados.setUsuarioSaldo(Validacao.getContaAtual(), Validacao.getStatusContaAtual()) 
	                		 && BancoDados.setUsuarioSaldo(Validacao.getContaDestino(), Validacao.getStatusContaDestino())) {
	                	 
	                	 System.out.println("transferencia efetuada com sucesso");
	                	 
	                	 Validacao.setStatusContaAtual(BancoDados.InfoUsuarioNum("select saldo from "+BancoDados.getTabela()+" where nome='"+Validacao.getContaAtual()+"';", "saldo"));
	                	 Validacao.setStatusContaDestino(BancoDados.InfoUsuarioNum("select saldo from "+BancoDados.getTabela()+" where nome='"+Validacao.getContaDestino()+"';", "saldo"));
	                	 
	                	 System.out.println("Status da conta: "+Validacao.getContaAtual()+" R$"+Validacao.getStatusContaAtual()+"\nStatus da conta do(a)"+Validacao.getContaDestino()+" R$"+Validacao.getStatusContaDestino());
	 	            	boolean ask=true;
	 	                while(ask) {
	 		            	Scanner input3=new Scanner(System.in);
	 		                System.out.println("1 selecionar outra conta\n2 voltar ao menu principal");
	 		                int escolha;
	 		                try {
	 		                	escolha=input3.nextInt();
	 		                }catch(java.util.InputMismatchException e) {
	 		   	  	    	continue;
	 		   	  	    }
	 		               switch(escolha){
	 			                case 1:	ask=false;
	 			                		continue;
	 			                case 2:
	 			                		ask=false;
	 			                		repeat=false;
	 			                		continue;
	 			                		
	 			                default : ask=true;
	 		               }
	 		              
	 	                }
	 	               continue;
	                
	            	}
	                   
	            }
	            
	            else {
	            	System.out.println("saldo insuficiente");
	            	
	            }
	             
	        }
	        
	        else{
	        	System.out.println("conta nao encontrada");
	        	boolean elseRepeat=true;
	        	while(elseRepeat) {
			        Scanner input2=new Scanner(System.in);
			        System.out.println("1 selecionar outra conta\n2 voltar ao menu principal");
			         try {
			        	int escolha=input2.nextInt();
				        switch(escolha) {
				        case 1: elseRepeat=false;
				        break;
				        case 2: elseRepeat=false; 
				        	repeat=false;
				        	break;
				        default :continue;
				        }
			        }catch(java.util.InputMismatchException e){
			        	continue;
			        }
	       }
	       
	    
	    
	    }
		}
}

public static void sacar(){
	boolean repeat=true;
	while(repeat) {
		System.out.println("status da conta "+Validacao.getStatusContaAtual());
	
		Scanner input=new Scanner(System.in);
		System.out.println("digite o valor que deseja sacar");
		Double valor;
		try {
			valor=input.nextDouble();
		}catch(java.util.InputMismatchException e) {
		    	continue;
		    }
		if(Validacao.getStatusContaAtual()>=valor && valor>=0) {
	
			Double acount=Validacao.getStatusContaAtual()-valor;
			Validacao.setStatusContaAtual(acount);
			System.out.println("status da conta: "+Validacao.getContaAtual()+"\nR$ "+Validacao.getStatusContaAtual());
	
			Scanner input2=new Scanner(System.in);
			System.out.println("1 menu principal\n2 sacar novamente");
			int escolha;
			try {
				escolha=input2.nextInt();
			}catch(java.util.InputMismatchException e) {
	  	    	continue;
	  	    }
			switch(escolha){
			case 1:repeat=false;
			break;
			case 2:continue;
			}
			
		}
		else {
			System.out.println("valor invalido");
			continue;
		}
	}
}

public static void status(){
	boolean repeat=true;
	while(repeat) {
		System.out.println("conta: "+Validacao.getContaAtual()+"\nsaldo: "+Validacao.getStatusContaAtual()+"\n1 menu principal \n2 checar novamente o status da conta");
		Scanner input=new Scanner(System.in);
		int escolha;
		try {
			escolha=input.nextInt();
		}catch(java.util.InputMismatchException e) {
  	    	continue;
  	    }
		switch(escolha) {
		case 1:repeat=false;
		break;
		case 2:continue;
		default : continue;
		}
	}
}

}
        