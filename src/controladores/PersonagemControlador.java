package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Acesso;
import utils.PersonagemUtils;
import classes.basicas.Personagem;

public class PersonagemControlador {

	static PreparedStatement declaracao;
	static ResultSet resultado;
	static String criapersonagem 		= 	"INSERT INTO PERSONAGEM (VIDA, VIDAATUAL, ENERGIA, ENERGIAATUAL, DANONORMAL, DANOMAGIA, RESISTENCIANORMAL,"+
											" RESISTENCIAMAGIA, PRECISAO, ESQUIVA, NIVEL, EXPERIENCIA, CLASSE, EQUIPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	static String listapersonagens		= 	"SELECT * FROM PERSONAGEM";
	
	static String atualizapersonagem 	= 	"UPDATE PERSONAGEM SET VIDA = ?, VIDAATUAL = ?, ENERGIA = ?, ENERGIAATUAL = ?, DANONORMAL = ?, DANOMAGIA = ?, "+
											"RESISTENCIANORMAL = ?, RESISTENCIAMAGIA = ?, PRECISAO = ?, ESQUIVA = ?, NIVEL = ?, EXPERIENCIA = ?, CLASSE = ?, EQUIPE = ? "+
											"WHERE PERSONAGEMID = ?";
	
	public PersonagemControlador() {

	}
	
	public static void CriaPersonagem(Personagem personagem)	{
		try {
			declaracao = Acesso.conectar().prepareStatement(criapersonagem);
			declaracao.setDouble	(1, personagem.getVida());
			declaracao.setDouble	(2, personagem.getVidaAtual());
			declaracao.setInt		(3, personagem.getEnergia());
			declaracao.setInt		(4, personagem.getEnergiaAtual());
			declaracao.setDouble	(5, personagem.getDanoNormal());
			declaracao.setDouble	(6, personagem.getDanoMagia());
			declaracao.setDouble	(7, personagem.getResistenciaNormal());
			declaracao.setDouble	(8, personagem.getResistenciaMagia());
			declaracao.setFloat		(9, personagem.getPrecisao());
			declaracao.setFloat		(10, personagem.getEsquiva());
			declaracao.setInt		(11, personagem.getNivel());
			declaracao.setInt		(12, personagem.getExperiencia());
			declaracao.setString	(13, personagem.getClasse());
			declaracao.setString	(14, personagem.getEquipe());
			declaracao.executeUpdate();
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> ListaColuna(String parametro)	{
		List<String> lista = new ArrayList<String>();
		try	{
			String listacoluna = "SELECT "+parametro+" FROM PERSONAGEM";
			declaracao = Acesso.conectar().prepareStatement(listacoluna);
			resultado = declaracao.executeQuery();
			while (resultado.next())	{
				lista.add(resultado.getString(parametro));
			}
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static List<String> ListaColunaDistinta(String parametro)	{
		List<String> lista = new ArrayList<String>();
		try	{
			String listacoluna = "SELECT DISTINCT "+parametro+" FROM PERSONAGEM";
			declaracao = Acesso.conectar().prepareStatement(listacoluna);
			resultado = declaracao.executeQuery();
			while (resultado.next())	{
				lista.add(resultado.getString(parametro));
			}
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static List<Personagem> ListaPersonagens(String parametro, String pesquisa)	{
		List<Personagem> lista = new ArrayList<Personagem>();
		String listapersonagens = "SELECT * FROM PERSONAGEM WHERE "+parametro+" = ?";
		try {
			declaracao = Acesso.conectar().prepareStatement(listapersonagens);
			declaracao.setString(1, pesquisa);
			resultado = declaracao.executeQuery();
			Personagem personagem;
			while (resultado.next())	{
				personagem = PersonagemUtils.EscolheClasse(resultado.getString("CLASSE"));
				personagem.setVida				(resultado.getDouble("VIDA"));
				personagem.setVidaAtual			(resultado.getDouble("VIDAATUAL"));
				personagem.setEnergia			(resultado.getInt	("ENERGIA"));
				personagem.setEnergiaAtual		(resultado.getInt	("ENERGIAATUAL"));
				personagem.setDanoNormal		(resultado.getDouble("DANONORMAL"));
				personagem.setDanoMagia			(resultado.getDouble("DANOMAGIA"));
				personagem.setResistenciaNormal	(resultado.getDouble("RESISTENCIANORMAL"));
				personagem.setResistenciaMagia	(resultado.getDouble("RESISTENCIAMAGIA"));
				personagem.setPrecisao			(resultado.getFloat	("PRECISAO"));
				personagem.setEsquiva			(resultado.getFloat	("ESQUIVA"));
				personagem.setNivel				(resultado.getInt	("NIVEL"));
				personagem.setExperiencia		(resultado.getInt	("EXPERIENCIA"));
				personagem.setEquipe			(resultado.getString("EQUIPE"));
				personagem.setId				(resultado.getInt	("PERSONAGEMID"));
				lista.add(personagem);
			}
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static List<Personagem> ListaPersonagens()	{
		List<Personagem> lista = new ArrayList<Personagem>();
		try {
			declaracao = Acesso.conectar().prepareStatement(listapersonagens);
			resultado = declaracao.executeQuery();
			Personagem personagem;
			while (resultado.next())	{
				personagem = PersonagemUtils.EscolheClasse(resultado.getString("CLASSE"));
				personagem.setVida				(resultado.getDouble("VIDA"));
				personagem.setVidaAtual			(resultado.getDouble("VIDAATUAL"));
				personagem.setEnergia			(resultado.getInt("ENERGIA"));
				personagem.setEnergiaAtual		(resultado.getInt("ENERGIAATUAL"));
				personagem.setDanoNormal		(resultado.getDouble("DANONORMAL"));
				personagem.setDanoMagia			(resultado.getDouble("DANOMAGIA"));
				personagem.setResistenciaNormal	(resultado.getDouble("RESISTENCIANORMAL"));
				personagem.setResistenciaMagia	(resultado.getDouble("RESISTENCIAMAGIA"));
				personagem.setPrecisao			(resultado.getFloat("PRECISAO"));
				personagem.setEsquiva			(resultado.getFloat("ESQUIVA"));
				personagem.setNivel				(resultado.getInt("NIVEL"));
				personagem.setExperiencia		(resultado.getInt("EXPERIENCIA"));
				personagem.setEquipe			(resultado.getString("EQUIPE"));
				personagem.setId				(resultado.getInt("PERSONAGEMID"));
				lista.add(personagem);
			}
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void AtualizaPersonagens(List<Personagem> lista)	{
		try {
			declaracao = Acesso.conectar().prepareStatement(atualizapersonagem);
			for (Personagem personagem : lista) {
				declaracao.setDouble	(1, personagem.getVida());
				declaracao.setDouble	(2, personagem.getVidaAtual());
				declaracao.setInt		(3, personagem.getEnergia());
				declaracao.setInt		(4, personagem.getEnergiaAtual());
				declaracao.setDouble	(5, personagem.getDanoNormal());
				declaracao.setDouble	(6, personagem.getDanoMagia());
				declaracao.setDouble	(7, personagem.getResistenciaNormal());
				declaracao.setDouble	(8, personagem.getResistenciaMagia());
				declaracao.setFloat		(9, personagem.getPrecisao());
				declaracao.setFloat		(10, personagem.getEsquiva());
				declaracao.setInt		(11, personagem.getNivel());
				declaracao.setInt		(12, personagem.getExperiencia());
				declaracao.setString	(13, personagem.getClasse());
				declaracao.setString	(14, personagem.getEquipe());
				declaracao.setInt		(15, personagem.getId());
				declaracao.executeUpdate();
			}
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void AtualizaPersonagem(Personagem personagem)	{
		try {
			declaracao = Acesso.conectar().prepareStatement(atualizapersonagem);
			declaracao.setDouble	(1, personagem.getVida());
			declaracao.setDouble	(2, personagem.getVidaAtual());
			declaracao.setInt		(3, personagem.getEnergia());
			declaracao.setInt		(4, personagem.getEnergiaAtual());
			declaracao.setDouble	(5, personagem.getDanoNormal());
			declaracao.setDouble	(6, personagem.getDanoMagia());
			declaracao.setDouble	(7, personagem.getResistenciaNormal());
			declaracao.setDouble	(8, personagem.getResistenciaMagia());
			declaracao.setFloat		(9, personagem.getPrecisao());
			declaracao.setFloat		(10, personagem.getEsquiva());
			declaracao.setInt		(11, personagem.getNivel());
			declaracao.setInt		(12, personagem.getExperiencia());
			declaracao.setString	(13, personagem.getClasse());
			declaracao.setString	(14, personagem.getEquipe());
			declaracao.setInt		(15, personagem.getId());
			declaracao.executeUpdate();
			Acesso.Desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
