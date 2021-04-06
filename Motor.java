package Engine;

import Ações.Interacoes;
import Player.Jogador;

public class Motor {

	private int rodadas = 1;  

	int at_Jogador; 
	int at_Dado; 

	public Jogador player1 = new Jogador("Bárbaro",40,50);  
	public Jogador player2 = new Jogador("Romano",50,40);  

	Interacoes inter = new Interacoes();  

	public void criar_Round_Intro() {   
		System.out.println("Que a sorte te acompanhe. Você tem 10 Rounds...");
		System.out.println("___________________________");
		System.out.println();
		System.out.println("A BATALHA VAI COMEÇAR");
		System.out.println("___________________________");
		System.out.println();
		System.out.println("Hérois em batalha:");
		System.out.println();
		player1.imp_Dados(0);                      
		player2.imp_Dados(0); 
		System.out.println();
		at_Jogador = player1.ver_Primeiro_Jogador();
		player1.imp_Dados(at_Jogador);
	}

	public void criar_Round() {
		System.out.println();
		System.out.println("...::: RODADA " + rodadas++ + " :::..."); 
		System.out.println();
		System.out.println("Dado ao vento.... aperte enter para jogar");
		inter.criar_Linha();
		at_Dado = inter.jogar_Dado();
		System.out.println("Eeeeeee ele parou no " + "(" + at_Dado + ")");
		System.out.println();   

		if(at_Jogador == 2) {	
			at_Jogador = 1; 
			player1.rem_Energia(at_Dado, player2.poder);
			player1.imp_Dados(0);
			player2.imp_Dados(0); 
			System.out.println();
			imp_Ou_Nao(); 
		}else {			
			at_Jogador = 2;
			player2.rem_Energia(at_Dado, player1.poder); 
			player1.imp_Dados(0);
			player2.imp_Dados(0);
			System.out.println();
			imp_Ou_Nao();
		}	

		if(player1.energia <= 0) {  
			inter.todos_Finais(1, player2.energia, player2.nome);
		}else if(player2.energia <= 0){
			inter.todos_Finais(1, player1.energia, player1.nome); 
		}else if(rodadas == 11) {
			inter.todos_Finais(0,0,""); 
		}
	}

	public void imp_Ou_Nao() {
		if(player2.energia <= 0 || player1.energia <= 0 || rodadas == 11) {

		}else if(at_Jogador == 1){
			System.out.println("_______________________________________" + "O Héroi " + player1.nome + " Ataca agora...");
		}else{
			System.out.println("_______________________________________" + "O Héroi " + player2.nome + " Ataca agora...");	
		}
	}
}
