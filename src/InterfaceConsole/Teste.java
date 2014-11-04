package InterfaceConsole;

import java.util.List;

import classes.basicas.Personagem;
import conexao.PersonagemControlador;


public class Teste {

	public static void main(String[] args) {
		
//		Demonio ant = new Demonio();
//		Guerreiro gue = new Guerreiro();
//		ant.CriarPersonagem(2.5, 2.5, 2.5, 2.5,"Vermelho");
//		gue.CriarPersonagem(2.5, 2.5, 2.5, 2.5,"Azul");
//		List<Personagem> lista = new ArrayList<Personagem>();
//		lista.add(gue);
//		lista.add(ant);
		
		List<Personagem> lista = PersonagemControlador.ListaPersonagens("EQUIPE","Azul");
		for (Personagem personagem : lista) {
			System.out.println(personagem.toString());
		}
		
		lista.get(0).setVida(100);
		PersonagemControlador.AtualizaPersonagens(lista);
		lista.get(0).setVida(80);
		PersonagemControlador.AtualizaPersonagem(lista.get(0));
	}
	
}
