package Engine;

import java.util.Random;
import java.util.Scanner;
import Player.Jogador;

public class Motor {

	private int rodadas = 1;  

	int at_Jogador; 
	int at_Dado; 

	public Jogador player1 = new Jogador("Bárbaro",40,50);  
	public Jogador player2 = new Jogador("Romano",50,40);  	

	public int jogar_Dado() {                                                                                           
		int ver_d = 0;	
		Random vr_d = new Random();	

		for(int d = 0; d < 100; d++) {
			ver_d = vr_d.nextInt( 100 ) + 1;	 
			break;
		}
		return ver_d;                                                                                           
	}

	public void criar_Linha() {                                                   
		Scanner sx = new Scanner(System.in);
		sx.nextLine();
	}

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
		if (at_Jogador == 1) {
			player1.imp_Dados(1);
		}else {
			player2.imp_Dados(1);
		}
	}

	public void criar_Round() {
		System.out.println();
		System.out.println("...::: RODADA " + rodadas++ + " :::..."); 
		System.out.println();
		System.out.println("Dado ao vento.... aperte enter para jogar");
		criar_Linha();
		at_Dado = jogar_Dado();
		System.out.println("Eeeeeee ele parou no " + "(" + at_Dado + ")");
		System.out.println();   

		if(at_Jogador == 2) {	
			at_Jogador = 1; 
			player1.rem_Energia(at_Dado, player2.poder);
			player1.imp_Dados(2);
			player2.imp_Dados(2); 
			System.out.println();
			imp_Ou_Nao(); 
		}else {			
			at_Jogador = 2;
			player2.rem_Energia(at_Dado, player1.poder); 
			player1.imp_Dados(2);
			player2.imp_Dados(2);
			System.out.println();
			imp_Ou_Nao();
		}	

		if(player1.energia <= 0) {  
			player2.todos_Finais(1);
		}else if(player2.energia <= 0){
			player1.todos_Finais(1); 
		}else if(rodadas == 11) {
			player1.todos_Finais(0); 
		}
	}

	public void imp_Ou_Nao() {
		if(player2.energia == 0 || player1.energia == 0 || rodadas == 11) {

		}else if(at_Jogador == 1){
			player1.imp_Dados(3);
		}else{
			player2.imp_Dados(3);
		}
	}
}
