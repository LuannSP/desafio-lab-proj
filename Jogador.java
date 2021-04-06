package Player;

import java.util.Random;
import Engine.Motor;

public class Jogador {

	public String nome;
	public int energia;
	public int poder;

	public Jogador(String nome, int energia, int poder){
		this.nome = nome;
		this.energia = energia;
		this.poder = poder;
	}

	public void imp_Dados(int ver_Dados) {
		switch(ver_Dados) {
		case 1:
			System.out.println("_______________________________________" + "O Héroi " + this.nome + " começa atacando...");
			break;
		case 2:
			System.out.println("Héroi: " + this.nome + " | Energia: " + this.energia);
			break;
		default:
			System.out.println("Héroi: " + this.nome + " | Energia: " + this.energia + " | Poder: " + this.poder);
			break;
		}			
	}  

	public int ver_Primeiro_Jogador() { 
		int ver = 0;
		Random vr = new Random();
		for(int i = 0; i < 2; i++) {
			ver = vr.nextInt( 2 ) + 1;
			break;
		}
		return ver; 
	}

	public void todos_Finais(int ver_Final) {	    
		Motor enx = new Motor();
		switch (ver_Final) {   
		case 1:
			System.out.println();
			System.out.println("O JOGO ACABOU! O Héroi vencedor foooooi: " + this.nome + " com HP: " + this.energia);                                          
			System.out.println("_______________________________________");
			enx.criar_Linha(); 
			System.exit(0); 
			break;
		default:
			System.out.println();
			System.out.println("O JOGO ACABOU! Os dois Hérois são incriveis Parabéns....");	 
			System.out.println("_______________________________________");
			enx.criar_Linha();	 
			System.exit(0);	 
			break;
		}	
	}

	public void rem_Energia(int at_Dado, int at_poder) {
		int at_Dano;
		if (at_Dado >= 0 &&  at_Dado <= 15) {			
			System.out.println("Não desista, sem dano.");	
			System.out.println();

		}else if (at_Dado >= 16 && at_Dado <= 70) {			
			at_Dano = (at_poder/3);		
			System.out.println("Dano nível NORMAL -" + at_Dano + " HP  ");	
			System.out.println();
			this.energia = this.energia - at_Dano;

		}else if (at_Dado >= 71 && at_Dado <= 96) {		
			at_Dano = (int) ((at_poder/3)*(1.2));	
			System.out.println("Dano nivel SORTE -" + at_Dano + " HP");
			System.out.println();
			this.energia = this.energia - at_Dano;	

		}else {
			at_Dano = (int) ((at_poder/3)*(1.5));	
			System.out.println("Dano nível CRÍTICO -" + at_Dano + " HP");	
			System.out.println();
			this.energia = this.energia - at_Dano;	

		}
		if (this.energia < 0) {
			this.energia = 0;
		}
	}
}
