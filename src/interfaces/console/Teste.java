package interfaces.console;

import controladores.PersonagemControlador;


public class Teste {

	public static void main(String[] args) {
		
//		for (Personagem personagem : PersonagemControlador.ListaPersonagens()) {
//			System.out.println(personagem.toString());
//		}
		
//		PersonagemControlador.CriaPersonagem(PersonagemControlador.ListaPersonagens().get(0));
		
		for (String string : PersonagemControlador.ListaColuna("EQUIPE")) {
			System.out.println(string);
		};
		
	}
	
}
