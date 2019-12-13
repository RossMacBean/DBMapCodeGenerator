package procedureGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public abstract class ORMCodeGeneratorBase implements ORMCodeGenerator {

	@Override
	public String GenerateProcedureCode(Iterable<ProcedureInfo> procs) {
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		
		for (ProcedureInfo p : procs) {
			sb.append(GenerateProcedureCode(p));
			sb.append(newLine);
		}
		
		return sb.toString();
	}

	@Override
	public void GenerateProcedureCode(Path path, Iterable<ProcedureInfo> procs) {
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		
		String pathName = path.getFileName().toString();
		
		for (ProcedureInfo p :procs) {
			File f = new File(pathName + File.separator + p.getName() + ".java");
			
			FileWriter writer = null;
			
			try {
				writer = new FileWriter(f);
				sb.append(GenerateProcedureCode(p));
				sb.append(newLine);
				writer.write(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}
}
