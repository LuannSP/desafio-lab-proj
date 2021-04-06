package Menu;

import Engine.Motor;

public class Main {

	public static void main(String[] args) {
		Motor enx = new Motor();

		System.out.println("O Héroi está pronto para lutar? Aperte ENTER para iniciar.");

		enx.criar_Linha();

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
