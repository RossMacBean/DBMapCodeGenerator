package procedureGenerator;

public class ProcedureParameter {

	private String _name;
	private String _dataType;
	private String _defaultValue;
	private String _remarks;
	private ParameterType _parameterType;
	private boolean _nullable;

	ProcedureParameter(String name, String dataType, String defaultValue, String remarks, ParameterType parameterType, boolean nullable) {
		_name = name;
		_dataType = dataType;
		_defaultValue = defaultValue;
		_remarks = remarks;
		_parameterType = parameterType;
		_nullable = nullable;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getDataType() {
		return _dataType;
	}
	
	public String getDefaultValue() {
		return _defaultValue;
	}
	
	public String getRemarks() {
		return _remarks;
	}

	public ParameterType getArgumentType() {
		return _parameterType;
	}
	
	public boolean isNullable() {
		return _nullable;
	}
}
