package iteration04.fr.agh.services;

import java.util.HashMap;
import java.util.Map;

import iteration04.fr.agh.domain.Cell;
import iteration04.fr.agh.domain.Dimension;
import iteration04.fr.agh.domain.Grid;
import iteration04.fr.agh.domain.State;
import utils.Constantes;
/**
 * @author elm
 *
 */
public class ConsolePrintService implements PrintService {
	
	private static final int MARGE=30;

	private static Map<State, String> keyMap = new HashMap<>();

	static {
		keyMap.put(State.DEAD, Constantes.MINUS);
		keyMap.put(State.ALIVE, Constantes.PLUS);
	}

	@Override
	public void print(int stepNumber, Grid grid, Dimension dimension) {
		// format to a 4 digit number
		String s4d = String.format("%04d", stepNumber);
		int height=dimension.getY()+MARGE;
		String line = repeatLine("+", "-",height );
		String stepLineGap = repeatLine("", " ", height-10);

		System.out.println(line);
		System.out.println("| Step " + s4d + stepLineGap + "|");
		System.out.println(line);
		if (dimension.getX() == 1) {
			String formatedLine = this.formatLine(grid.getCells());
			printLine(formatedLine,height);
		} else {
			Cell[] cells = grid.getCells();
			for (int i = 0; i < cells.length; i++) {
				String formatedLine = keyMap.get(cells[i].getState());
				printLine(formatedLine,height);
			}
		}

		System.out.println(line);

	}

	public void printLine(String formatedLine,int height) {
		int restOfLineByTwo = (height - formatedLine.length()) / 2;
		String gap = repeatLine("", " ", restOfLineByTwo);
		System.out.println(gap + formatedLine + gap);
	}

	public String repeatLine(String border, String element, int count) {

		StringBuilder sb = new StringBuilder(border);
		for (int i = 0; i < count; i++) {
			sb.append(element);
		}
		sb.append(border);
		return sb.toString();

	}

	public String formatLine(Cell[] cells) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cells.length; i++) {
			sb.append(keyMap.get(cells[i].getState()));
		}
		return sb.toString();

	}

}
