package classes.basicas;

import utils.Chance;

public class Personagem {
	protected double  		Vida;
	protected double		VidaAtual;
	protected int 			Energia;
	protected int			EnergiaAtual;
	protected double 		DanoNormal;
	protected double 		DanoMagia;
	protected double 		ResistenciaNormal;
	protected double 		ResistenciaMagia;
	protected float 		Precisao;
	protected float 		Esquiva;
	protected int	 		Nivel;
	protected int			Experiencia;
	protected String		Classe;
	
	public void Definicao(	double vida,double vidaAtual, int energia, int energiaAtual,  double danoNormal, double danoMagia, 
						double resistenciaNormal,double resistenciaMagia, float precisao, float esquiva, int nivel, int experiencia, String classe) {
		Vida = vida;
		VidaAtual = vidaAtual;
		Energia = energia;
		EnergiaAtual = energiaAtual;
		DanoNormal = danoNormal;
		DanoMagia = danoMagia;
		ResistenciaNormal = resistenciaNormal;
		ResistenciaMagia = resistenciaMagia;
		Precisao = precisao;
		Esquiva = esquiva;
		Nivel = nivel;
		Experiencia = experiencia;
		Classe = classe;
	}

	public void DefinicaoInicial(double danoNormal, double danoMagia, double resistenciaNormal,double resistenciaMagia)	{
		Vida = 80;
		VidaAtual = Vida;
		Energia = 100;
		EnergiaAtual = Energia;
		DanoNormal = 15 + danoNormal;
		DanoMagia = 15 + danoMagia;
		ResistenciaNormal = 6 + resistenciaNormal; 
		ResistenciaMagia = 6 + resistenciaMagia;
		Precisao = .8f;
		Esquiva = .05f;
		Nivel = 1;
		Experiencia = 0;
	}
	public void DefinicaoInicial1(){}
	public void DefinicaoInicial2(){}
	
	public void CriarPersonagem(double danoNormal, double danoMagia, double resistenciaNormal,double resistenciaMagia)	{
		DefinicaoInicial(danoNormal, danoMagia, resistenciaNormal,resistenciaMagia);
		DefinicaoInicial1();
		DefinicaoInicial2();
	}
	
	public void AtacaPersonagem(Personagem inimigo)	{
		double ataque = DanoNormal - inimigo.getResistenciaNormal()/2;
		if (Chance.ConsegueAcertar(Precisao))	{
			if (!Chance.ConsegueEsquivar(inimigo.getEsquiva()))	{
				inimigo.setVidaAtual(inimigo.getVidaAtual()-ataque);
			}
		}
	}

	@Override
	public String toString() {
		return "Personagem [Vida=" + Vida + ", VidaAtual=" + VidaAtual
				+ ", Energia=" + Energia + ", EnergiaAtual=" + EnergiaAtual
				+ ", DanoNormal=" + DanoNormal + ", DanoMagia=" + DanoMagia
				+ ", ResistenciaNormal=" + ResistenciaNormal
				+ ", ResistenciaMagia=" + ResistenciaMagia + ", Precisao="
				+ Precisao + ", Esquiva=" + Esquiva + ", Nivel=" + Nivel
				+ ", Experiencia=" + Experiencia + ", Classe=" + Classe + "]";
	}

	public double getVida() {
		return Vida;
	}

	public void setVida(double vida) {
		Vida = vida;
	}

	public double getVidaAtual() {
		return VidaAtual;
	}

	public void setVidaAtual(double vidaAtual) {
		VidaAtual = vidaAtual;
	}

	public int getEnergia() {
		return Energia;
	}

	public void setEnergia(int energia) {
		Energia = energia;
	}

	public int getEnergiaAtual() {
		return EnergiaAtual;
	}

	public void setEnergiaAtual(int energiaAtual) {
		EnergiaAtual = energiaAtual;
	}

	public double getDanoNormal() {
		return DanoNormal;
	}

	public void setDanoNormal(double danoNormal) {
		DanoNormal = danoNormal;
	}

	public double getDanoMagia() {
		return DanoMagia;
	}

	public void setDanoMagia(double danoMagia) {
		DanoMagia = danoMagia;
	}

	public double getResistenciaNormal() {
		return ResistenciaNormal;
	}

	public void setResistenciaNormal(double resistenciaNormal) {
		ResistenciaNormal = resistenciaNormal;
	}

	public double getResistenciaMagia() {
		return ResistenciaMagia;
	}

	public void setResistenciaMagia(double resistenciaMagia) {
		ResistenciaMagia = resistenciaMagia;
	}

	public float getPrecisao() {
		return Precisao;
	}

	public void setPrecisao(float precisao) {
		Precisao = precisao;
	}

	public float getEsquiva() {
		return Esquiva;
	}

	public void setEsquiva(float esquiva) {
		Esquiva = esquiva;
	}

	public int getNivel() {
		return Nivel;
	}

	public void setNivel(int nivel) {
		Nivel = nivel;
	}

	public int getExperiencia() {
		return Experiencia;
	}

	public void setExperiencia(int experiencia) {
		Experiencia = experiencia;
	}

}
