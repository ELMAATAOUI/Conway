package iteration03.fr.agh.services;

import java.util.HashMap;
import java.util.Map;

import iteration03.fr.agh.domain.Cell;
import iteration03.fr.agh.domain.Grid;
import iteration03.fr.agh.domain.State;
import utils.Constantes;
/**
 * @author elm
 *
 */
public class ConsolePrintService implements PrintService {
	
	private final static int MARGE=4;

	private static Map<State, String> keyMap = new HashMap<>();

	static {
		keyMap.put(State.DEAD, Constantes.MINUS);
		keyMap.put(State.ALIVE, Constantes.PLUS);
	}

	@Override
	public void print(int stepNumber, Grid grid) {
		// format to a 4 digit number
		String s4d = String.format("%04d", stepNumber);
		String formatedLine = this.formatLine(grid.getCells());
		
		int restOfLineByTwo=formatedLine.length()/2;
		String line=repeatLine("+","-",30);
		String gap=repeatLine(""," ",restOfLineByTwo);
		System.out.println(line);
		System.out.println("| Step " + s4d + repeatLine("","",20)+"|");
		System.out.println(line);
		System.out.println(gap+ formatedLine + gap);
		System.out.println(line);

	}
	
	public String repeatLine(String border,String element,int count) {
		
		StringBuilder sb= new StringBuilder(border);
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
