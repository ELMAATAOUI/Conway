package iteration02.fr.agh.services;

import java.util.HashMap;
import java.util.Map;

import iteration02.fr.agh.domain.Grid;
import iteration02.fr.agh.domain.State;
import utils.Constantes;
/**
 * @author elm
 *
 */
public class ConsolePrintService implements PrintService {

	private static Map<State, String> keyMap = new HashMap<>();

	static {
		keyMap.put(State.DEAD, Constantes.MINUS);
		keyMap.put(State.ALIVE, Constantes.PLUS);
	}

	@Override
	public void print(int stepNumber, Grid grid) {
		// format to a 4 digit number
		String s4d = String.format("%04d", stepNumber);
		String firstSign = keyMap.get(grid.getFirstCell().getState());
		String secondSign = "";
		if (grid.getSecondCell() != null) {
			secondSign = keyMap.get(grid.getSecondCell().getState());
		}

		System.out.println("+------------------------+");
		System.out.println("| Step " + s4d + "              |");
		System.out.println("+------------------------+");
		System.out.println("|      " + firstSign + secondSign + "                |");
		System.out.println("+------------------------+");

	}

}
