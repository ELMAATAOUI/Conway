package iteration01.fr.agh.services;
/**
 * @author elm
 *
 */
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import iteration01.Simulator;
import iteration01.fr.agh.domain.Cell;
import iteration01.fr.agh.domain.Grid;
import iteration01.fr.agh.domain.State;
import utils.Constantes;

public class FileLoadingService implements LoadingService {

	public static final Charset ENCODING = StandardCharsets.UTF_8;

	private String sourceFileName;

	/**
	 * @param sourceFileName
	 */
	public FileLoadingService(String sourceFileName) {
		super();
		this.sourceFileName = sourceFileName;
	}

	@Override
	public Simulator load() {
		List<String> lines = null;
		try {
			lines = readFile(this.sourceFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int numberOfIteration = this.extractNumberInteration(lines);
		int dimension = this.extractDimension(lines);
		Grid grid = this.extractGrid(lines);

		Simulator simulator = new Simulator(dimension, numberOfIteration, grid);

		return simulator;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}

	private int extractNumberInteration(List<String> lines) {
		return Integer.parseInt(lines.get(0));

	}

	private int extractDimension(List<String> lines) {
		return Integer.parseInt(lines.get(1));
	}

	private Grid extractGrid(List<String> lines) {
		Cell cell = new Cell();
		String sign = lines.get(2);
		if (Constantes.PLUS.equals(sign)) {
			cell.setState(State.ALIVE);
		}
		return new Grid(cell);
	}

}
