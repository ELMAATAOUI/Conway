package iteration05.fr.agh.domain;

import java.util.Arrays;

import iteration05.fr.agh.domain.State;
import iteration05.fr.agh.rule.LifeRule;
import iteration05.fr.agh.rule.Rule;
/**
 * @author elm
 *
 */
public class Grid {

	private Cell[][] cells;

	private Rule rule;

	public Grid() {
		super();
		this.rule = new LifeRule();
	}

	public Grid(Cell[][] cells) {
		super();
		this.cells = cells;
		this.rule = new LifeRule();
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public State newState(int i,int j) {
		return rule.apply(i,j, this);
	}

	public int sum(int i, int j) {
		int sum = 0;
		int living=0;
		if(this.isLiving(i, j)) {
			living=1;
		}
		// parcours des cellules alentours
		for (int k = i - 1; k <= i + 1; k++) {
			for (int h = j - 1; h <= j + 1; h++) {
				// sauf la cellule concerne
					if (this.isLiving(k, h)) {
						sum += 1;
					}

			}
		}
		return sum-living;
	}
	public void evolution() {
		Cell[][] tempCells=this.duplicateCells();
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
			tempCells[i][j].setState(newState(i,j));
			}
		}
		this.cells=tempCells;
	}
	
	

	public boolean isLiving(int i,int j) {
		try {
			if (cells[i][j] != null) {
				return State.ALIVE.equals(cells[i][j].getState());
			}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return false;

	}

	public Cell[][] duplicateCells() {
		Cell[][] tempCells = new Cell[cells.length][cells[0].length];
		for (int i = 0; i < tempCells.length; i++) {
			for (int j = 0; j < tempCells[i].length; j++) {
				tempCells[i][j] = new Cell(cells[i][j].getState());
			}
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
		if (!Arrays.deepEquals(cells, other.cells))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grid [cells=" + Arrays.toString(cells) + ", rule=" + rule + "]";
	}

}
