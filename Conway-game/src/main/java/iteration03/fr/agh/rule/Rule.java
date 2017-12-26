package iteration03.fr.agh.rule;

import iteration03.fr.agh.domain.Grid;
import iteration03.fr.agh.domain.State;
/**
 * @author elm
 *
 */
public interface Rule {
	
	public State apply(int index,Grid grid);

}
