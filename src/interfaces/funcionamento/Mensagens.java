package interfaces.funcionamento;

public class Mensagens {
	private static String Ocorrencias;
	private static String Informacoes;
	
	public static String getOcorrencias() {
		return Ocorrencias;
	}
	public static void setOcorrencias(String ocorrencias) {
		Ocorrencias = ocorrencias;
	}
	public static String getInformacoes() {
		return Informacoes;
	}
	public static void setInformacoes(String informacoes) {
		Informacoes = informacoes;
	}
	
	public static void incrementaOcorrencias(String ocorrencias) {
		Ocorrencias +="\r\n- "+ ocorrencias;
	}
}
