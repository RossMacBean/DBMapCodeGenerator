
import procedureGenerator.ProcedureGenerator;

public class RPCGenerator {

	static String schemaName = "sakila";
	static String connectionString = "jdbc:mysql://localhost:3306/";
	static String userName = "";
	static String password = "";
	
	public static void main(String[] args) {	
		ProcedureGenerator pg = new ProcedureGenerator();
		pg.Generate(connectionString, schemaName, userName, password);
	}
}
	
