package iteration05.fr.agh.rule;

import iteration05.fr.agh.domain.Grid;
import iteration05.fr.agh.domain.State;
/**
 * @author elm
 *
 */
public interface Rule {
	
	public State apply(int i,int j,Grid grid);

}
