
import procedureGenerator.ProcedureGenerator;

public class RPCGenerator {

	//TODO:: load this from user input
	static String schemaName = "sakila";
	static String connectionString = "jdbc:mysql://localhost:3306/";
	static String userName = "root";
	static String password = "password";
	
	public static void main(String[] args) {	
		ProcedureGenerator pg = new ProcedureGenerator();
		pg.Generate(connectionString, schemaName, userName, password);
	}
}
	