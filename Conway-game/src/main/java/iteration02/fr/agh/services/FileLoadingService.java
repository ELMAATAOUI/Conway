package iteration02.fr.agh.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import iteration02.Simulator;
import iteration02.fr.agh.domain.Cell;
import iteration02.fr.agh.domain.Dimension;
import iteration02.fr.agh.domain.Grid;
import iteration02.fr.agh.domain.State;
import utils.Constantes;
/**
 * @author elm
 *
 */
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
		Dimension dimension = this.extractDimension(lines);
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

	private Dimension extractDimension(List<String> lines) {
		String[] dims = lines.get(1).split("x");
		int x = Integer.parseInt(dims[0]);
		int y = Integer.parseInt(dims[1]);
		return new Dimension(x, y);
	}

	private Grid extractGrid(List<String> lines) {
		Cell firtCell = new Cell();
		Cell secondCell = null;

		String signsLine = lines.get(2);
		String[] signs = signsLine.split("");

		if (Constantes.PLUS.equals(signs[0])) {
			firtCell.setState(State.ALIVE);
		}
		if (signs.length >= 2) {
			if (Constantes.PLUS.equals(signs[1])) {
				secondCell = new Cell((State.ALIVE));
			}
			secondCell = new Cell((State.DEAD));
		}
		return new Grid(firtCell, secondCell);
	}

}
