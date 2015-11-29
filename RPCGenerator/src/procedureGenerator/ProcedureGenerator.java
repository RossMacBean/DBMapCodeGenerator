package procedureGenerator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcedureGenerator {

	public ProcedureGenerator() {
		
	}
	
	public void Generate(String connectionString, String schemaName, String userName, String password) {
		try (Connection connection = DriverManager.getConnection(
				connectionString + schemaName,
				userName,
				password)) {
			System.out.println("Database connected");
			
			//Get MetaData
			ArrayList<ProcedureInfo> procs = new ArrayList<ProcedureInfo>();
			DatabaseMetaData dmd = connection.getMetaData();	
			ResultSet procData = dmd.getProcedures(null, null, null);
			

			while (procData.next()) {
				String name, schema;
				name = procData.getString("PROCEDURE_NAME");
				schema = procData.getString("PROCEDURE_CAT");
				
				ProcedureInfo p = new ProcedureInfo(name, schema);
				procs.add(p);
				p.populateParameters(dmd);
			}
			
			//TODO:: replace this with a method of loading any code generator dynamically (factory pattern?)
			ORMCodeGenerator cg = new JavaORMCodeGenerator();
			String result = cg.GenerateProcedureCode(procs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
