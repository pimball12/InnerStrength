package interfaces.console;

import java.util.ArrayList;
import java.util.List;

import utils.Chance;



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
//		
//		List<String> listaTimes = PersonagemControlador.ListaColunaDistinta("EQUIPE");
//		
//		for (String string : listaTimes) {
//			//System.out.println(string);
//		}
//		
//		Demonio demonio = new Demonio();
//		demonio.CriarPersonagem(3, 3, 3, 3, "lol");
//		Guerreiro guerreiro = new Guerreiro();
//		guerreiro.CriarPersonagem(3, 3, 3, 3, "lol");
//		
//		System.out.println(demonio + "\r\n" + guerreiro+ "\r\n");
//		guerreiro.AtaqueBrutal(demonio);
//		System.out.println(demonio + "\r\n" + guerreiro+ "\r\n");
//		
//		Demonio demonio1 = new Demonio();
//		demonio1.CriarPersonagem(3, 3, 3, 3, "lol");
//		Atirador atirador = new Atirador();
//		atirador.CriarPersonagem(3, 3, 3, 3, "lol");
//		
//		System.out.println(demonio1 + "\r\n" + guerreiro+ "\r\n");
//		atirador.TiroCerteiro(demonio1);
//		System.out.println(demonio1 + "\r\n" + guerreiro+ "\r\n");
//		float f = 3.123f;
//		System.out.println((int)f);
		List listaDeMagias = new ArrayList<String>(){{add("Descontrole");add("Ataque Brutal");add("Violencia");add("Curar");}};
		int num = listaDeMagias.size();
		System.out.println(Chance.numeroAleatorio(num));
	}
	
}
