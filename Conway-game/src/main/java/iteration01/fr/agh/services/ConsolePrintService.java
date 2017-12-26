package iteration01.fr.agh.services;

import java.util.HashMap;
import java.util.Map;

import iteration01.fr.agh.domain.Grid;
import iteration01.fr.agh.domain.State;
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
		String sign = keyMap.get(grid.getCell().getState());

		System.out.println("+------------------------+");
		System.out.println("| Step " + s4d + "              |");
		System.out.println("+------------------------+");
		System.out.println("|      " + sign + "                 |");
		System.out.println("+------------------------+");

	}

}
