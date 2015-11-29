package procedureGenerator;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcedureInfo {

	private String _name;
	private String _schema;
	private String _returnType;
	private ArrayList<ProcedureParameter> _parameters;
	
	ProcedureInfo(String name, String schema) {		
		this(name, schema, null);
	}
	
	ProcedureInfo(String name, String schema, String returnType) {
		_name = name;
		_returnType = returnType;
		_schema = schema;
		_parameters = new ArrayList<ProcedureParameter>();
	}
	
	//Setters & Getters
	public String getName() {
		return _name;
	}
	
	public String getSchema() {
		return _schema;
	}
	
	public String getReturnType() {
		return _returnType;
	}
	
	public ArrayList<ProcedureParameter> getParameters() {
		return _parameters;
	}
	
	public void populateParameters(DatabaseMetaData dmd) throws SQLException {
		ResultSet rs = dmd.getProcedureColumns(null, null, getName(), null);
		
		while (rs.next()) {
			String name, dataType, defaultValue, remarks;
			ParameterType parameterType;
			boolean nullable;
			
			short test = rs.getShort("COLUMN_TYPE");
			
			name = rs.getString("COLUMN_NAME");
			dataType = rs.getString("DATA_TYPE");
			defaultValue = rs.getString("COLUMN_DEF");
			remarks = rs.getString("REMARKS");
			nullable = rs.getBoolean("IS_NULLABLE");
			
			_parameters.add(new ProcedureParameter(name, dataType, defaultValue, remarks, null, nullable));
		}	
	}
}
