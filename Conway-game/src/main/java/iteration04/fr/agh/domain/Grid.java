package iteration04.fr.agh.domain;

import java.util.Arrays;

import iteration04.fr.agh.domain.State;
import iteration04.fr.agh.rule.LifeRule;
import iteration04.fr.agh.rule.Rule;
/**
 * @author elm
 *
 */
public class Grid {
		
	private Cell[] cells;

	private Rule rule;

	
	public Grid() {
		super();
		this.rule=new LifeRule();
	}
	
	public Grid(Cell[] cells) {
		super();
		this.cells=cells ;
		this.rule=new LifeRule();
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public State newState(int i) {
		return rule.apply(i,this);
	}

	public void evolution() {
		Cell[] tempCells=this.duplicateCells();
		for (int i = 0; i < tempCells.length; i++) {
			tempCells[i].setState(newState(i));
		}
		this.cells=tempCells;
	}
	
	public boolean isLiving(int i) {
		try {
			if(cells[i]!=null) {
				return State.ALIVE.equals(cells[i].getState());
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return false;

	}
	
	public Cell[] duplicateCells() {
		Cell[] tempCells=new Cell[cells.length];
		for (int i = 0; i < tempCells.length; i++) {
			tempCells[i]=new Cell(cells[i].getState());
		}
		return tempCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		if (!Arrays.equals(cells, other.cells))
			return false;
		if (rule == null) {
			if (other.rule != null)
				return false;
		} 
		return true;
	}

	@Override
	public String toString() {
		return "Grid [cells=" + Arrays.toString(cells) + ", rule=" + rule + "]";
	}

	




	
	

}
