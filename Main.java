package Menu;

import A��es.Interacoes;
import Engine.Motor;

public class Main {

	public static void main(String[] args) {
		Interacoes inter = new Interacoes(); 
		Motor enx = new Motor();

		System.out.println("O H�roi est� pronto para lutar? Aperte ENTER para iniciar.");

		inter.criar_Linha();

		enx.criar_Round_Intro(); 
		enx.criar_Round(); 
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
		enx.criar_Round();
	}
}
