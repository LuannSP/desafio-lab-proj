package Player;

import java.util.Random;

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

	public int danos(int at_Dano,int at_poder) {	
		switch(at_Dano) {
		case 1:
			at_Dano = (at_poder/3);	
			break;
		case 2:
			at_Dano = (int) ((at_poder/3)*(1.2));	
			break;
		case 3:
			at_Dano = (int) ((at_poder/3)*(1.5));	
			break;
		}
		return at_Dano; 
	}

	public void rem_Energia(int at_Dado, int at_poder) {
		if (at_Dado >= 0 &&  at_Dado <= 15) {			
			System.out.println("Não desista, sem dano.");	
			System.out.println();
		}else if (at_Dado >= 16 && at_Dado <= 70) {					
			System.out.println("Dano nível NORMAL -" + danos(1,at_poder) + " HP");	
			System.out.println();
			this.energia = this.energia - danos(1,at_poder);
		}else if (at_Dado >= 71 && at_Dado <= 96) {			
			System.out.println("Dano nivel SORTE -" + danos(2,at_poder) + " HP");
			System.out.println();
			this.energia = this.energia - danos(2,at_poder);	
		}else {
			System.out.println("Dano nível CRITICO -" + danos(3,at_poder) + " HP");	
			System.out.println();
			this.energia = this.energia - danos(3,at_poder);	
		}
		if (this.energia < 0) {
			this.energia = 0;
		}
	}
}
