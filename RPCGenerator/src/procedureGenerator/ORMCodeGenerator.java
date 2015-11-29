package procedureGenerator;

import java.io.File;
import java.nio.file.Path;

public interface ORMCodeGenerator {
	public String GenerateProcedureCode(ProcedureInfo proc);
	public void GenerateProcedureCode(File file, ProcedureInfo proc);
	
	public String GenerateProcedureCode(Iterable<ProcedureInfo> procs);
	public void GenerateProcedureCode(Path directory, Iterable<ProcedureInfo> procs);
}
