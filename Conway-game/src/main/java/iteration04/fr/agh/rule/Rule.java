package iteration04.fr.agh.rule;

import iteration04.fr.agh.domain.Grid;
import iteration04.fr.agh.domain.State;
/**
 * @author elm
 *
 */
public interface Rule {
	
	public State apply(int index,Grid grid);

}
