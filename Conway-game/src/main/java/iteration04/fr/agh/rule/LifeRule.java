package iteration04.fr.agh.rule;

import iteration04.fr.agh.domain.Grid;
import iteration04.fr.agh.domain.State;
/**
 * @author elm
 *
 */
public class LifeRule implements Rule {

	@Override
	public State apply(int index, Grid grid) {
		if (grid.isLiving(index - 1) && grid.isLiving(index) && grid.isLiving(index + 1)) {
			return State.ALIVE;
		}
		return State.DEAD;

	}

}
