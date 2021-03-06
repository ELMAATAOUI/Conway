package iteration05.fr.agh.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import iteration05.Simulator;
import iteration05.fr.agh.domain.Cell;
import iteration05.fr.agh.domain.Dimension;
import iteration05.fr.agh.domain.Grid;
import iteration05.fr.agh.domain.State;
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
		Grid grid = this.extractGrid(lines,dimension);

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
	private Grid extractGrid(List<String> lines,Dimension dimension) {
		
		List<String> subLines = lines.subList(2, lines.size());
		
		int rowCount=dimension.getX();
		int columnCount=dimension.getY();
		Cell[][] cells=new Cell[rowCount][columnCount];
		
		for(int i = 0; i < subLines.size(); i++)  {
			cells[i] = stringArrToCellArr(subLines.get(i).split(""));	
		}
		
	
		return new Grid(cells);
	}

	private Cell[] stringArrToCellArr(String[] s) {
		Cell[] result = new Cell[s.length];
		for (int i = 0; i < s.length; i++) {
			if (Constantes.PLUS.equals(s[i])) {
				result[i] = new Cell((State.ALIVE));
			} else {
				result[i] = new Cell((State.DEAD));
			}
		}
		return result;
	}

}
