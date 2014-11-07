package interfaces.console;

import java.util.List;

import controladores.PersonagemControlador;


public class Teste {

//	Test Area
	public static void main(String[] args) {
		
//		for (Personagem personagem : PersonagemControlador.ListaPersonagens()) {
//			System.out.println(personagem.toString());
//		}
		
//		PersonagemControlador.CriaPersonagem(PersonagemControlador.ListaPersonagens().get(0));
		
//		for (String string : PersonagemControlador.ListaColuna("EQUIPE")) {
//			System.out.println(string);
//		};
		
		List<String> listaTimes = PersonagemControlador.ListaColunaDistinta("EQUIPE");
		
		for (String string : listaTimes) {
			System.out.println(string);
		}
		
		
		
	}
	
}
