package iteration05.fr.agh.rule;

import iteration05.fr.agh.domain.Grid;
import iteration05.fr.agh.domain.State;
/**
 * @author elm
 *
 */
public class LifeRule implements Rule {

	
	@Override
	public State apply(int i,int j, Grid grid) {
		int sum = grid.sum(i, j);
		if (sum == 3) {
			return State.ALIVE;
		}
		if (grid.isLiving(i, j) && sum == 2) {
			return State.ALIVE;
		}
		if(sum<2 || sum>3) {
		return State.DEAD;
		}
		return State.DEAD;
		
		

	}

}
