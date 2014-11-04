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
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			conexao = DriverManager.getConnection(	"jdbc:firebirdsql:localhost/3050:c:\\Users\\Suporte 2\\Neto\\InnerStrength\\InnerStrength\\Data\\DATA.FDB?encoding=UTF8",
													"SYSDBA","masterkey");
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar ao banco de dados: ");
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
