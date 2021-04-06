package Ações;

import java.util.Random;
import java.util.Scanner;

public class Interacoes {

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

	public void todos_Finais(int ver_Final,int energia, String nome) {	                                                                                                                                                 
		switch (ver_Final) {   
		case 1:
			System.out.println();
			System.out.println("O JOGO ACABOU! O Héroi vencedor foooooi: " + nome + " com HP: " + energia);                                          
			System.out.println("_______________________________________");
			criar_Linha(); 
			System.exit(0); 
			break;
		default:
			System.out.println();
			System.out.println("O JOGO ACABOU! Os dois Hérois são incriveis Parabéns....");	 
			System.out.println("_______________________________________");
			criar_Linha();	 
			System.exit(0);	 
			break;
		}	
	}
}
