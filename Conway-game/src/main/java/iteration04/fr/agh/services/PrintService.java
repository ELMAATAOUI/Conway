package iteration04.fr.agh.services;

import iteration04.fr.agh.domain.Dimension;
import iteration04.fr.agh.domain.Grid;
/**
 * @author elm
 *
 */
public interface PrintService {
	
	public void print(int stepNumber,Grid grid,Dimension dimension);

}
