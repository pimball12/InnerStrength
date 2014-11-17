package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Acesso {
	
	static Connection conexao;
	
	public static void main(String[] args) {
		Acesso.conectar();
	}
	
	public static Connection conectar()	{
		String path = null;
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			//path = Acesso.class.getResource("/data/DATA.FDB").toString();
			path = path.substring(6).replace("/", "\\\\").replace("%20"," ");
			path = path.substring(10).replace("/", "\\\\").replace("%20"," ").replace("teste.jar!", "data");
			conexao = DriverManager.getConnection(	"jdbc:firebirdsql:localhost/3050:"+path+"?encoding=UTF8",
													"SYSDBA","masterkey");
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar ao banco de dados: ");
			System.out.println(path);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Não foi possível conectar ao driver");
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public static void Desconectar()	{
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

//conexao = DriverManager.getConnection(	"jdbc:firebirdsql:localhost/3050:c:\\Users\\Suporte 2\\Neto\\InnerStrength\\InnerStrength\\Data\\DATA.FDB?encoding=UTF8",
//"SYSDBA","masterkey");