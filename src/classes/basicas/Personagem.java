package classes.basicas;

public class Personagem {
	protected int  		Vida;
	protected int 		Energia;
	protected double 	DanoNormal;
	protected double 	DanoMagia;
	protected double 	ResistenciaNormal;
	protected double 	ResistenciaMagia;
	protected float 	Precisao;
	protected float 	Esquiva;
	protected int	 	Nivel;
	
	public void Definicao(	int vida, int energia, double danoNormal, double danoMagia, 
						double resistenciaNormal,double resistenciaMagia, float precisao, float esquiva, int nivel) {
		Vida = vida;
		Energia = energia;
		DanoNormal = danoNormal;
		DanoMagia = danoMagia;
		ResistenciaNormal = resistenciaNormal;
		ResistenciaMagia = resistenciaMagia;
		Precisao = precisao;
		Esquiva = esquiva;
		Nivel = nivel;
	}

	public void DefinicaoInicial(double danoNormal, double danoMagia, double resistenciaNormal,double resistenciaMagia)	{
		Vida = 80;
		Energia = 100;
		DanoNormal = 25 + danoNormal;
		DanoMagia = 25 + danoMagia;
		ResistenciaNormal = 4 + resistenciaNormal; 
		ResistenciaMagia = 4 + resistenciaMagia;
		Precisao = .8f;
		Esquiva = .05f;
		Nivel = 1;
	}
	public void DefinicaoInicial1(){}
	public void DefinicaoInicial2(){}
	
	public void CriarPersonagem(double danoNormal, double danoMagia, double resistenciaNormal,double resistenciaMagia)	{
		DefinicaoInicial(danoNormal, danoMagia, resistenciaNormal,resistenciaMagia);
		DefinicaoInicial1();
		DefinicaoInicial2();
	}
	
	public String toString() {
		return "Personagem [Vida=" + Vida + ", Energia=" + Energia
				+ ", DanoNormal=" + DanoNormal + ", DanoMagia=" + DanoMagia
				+ ", ResistenciaNormal=" + ResistenciaNormal
				+ ", ResistenciaMagia=" + ResistenciaMagia + ", Precisao="
				+ Precisao + ", Esquiva=" + Esquiva + ", Nivel=" + Nivel + "]";
	}

	public int getVida() {
		return Vida;
	}
	public void setVida(int vida) {
		Vida = vida;
	}
	public int getEnergia() {
		return Energia;
	}
	public void setEnergia(int energia) {
		Energia = energia;
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
}
