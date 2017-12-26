package iteration02.fr.agh.domain;
/**
 * @author elm
 *
 */
public class Grid {
		
	private Cell firstCell;
	private Cell secondCell;

	
	public Grid() {
		super();
	}
	
	public Grid(Cell firstCell) {
		super();
		this.firstCell = firstCell;
	}


	public Grid(Cell firstCell,Cell secondCell) {
		super();
		this.firstCell = firstCell;
		this.secondCell=secondCell;
	}
	
	

	public Cell getFirstCell() {
		return firstCell;
	}


	public void setFirstCell(Cell firstCell) {
		this.firstCell = firstCell;
	}


	public Cell getSecondCell() {
		return secondCell;
	}


	public void setSecondCell(Cell secondCell) {
		this.secondCell = secondCell;
	}


	public State newState(Cell cell) {
		return State.DEAD;
	}

	public void evolution() {
		this.firstCell.setState(newState(firstCell));
		if(secondCell!=null)
		this.secondCell.setState(newState(secondCell));
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstCell == null) ? 0 : firstCell.hashCode());
		result = prime * result + ((secondCell == null) ? 0 : secondCell.hashCode());
		return result;
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
		if (firstCell == null) {
			if (other.firstCell != null)
				return false;
		} else if (!firstCell.equals(other.firstCell))
			return false;
		if (secondCell == null) {
			if (other.secondCell != null)
				return false;
		} else if (!secondCell.equals(other.secondCell))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Grid [firstCell=" + firstCell + ", secondCell=" + secondCell + "]";
	}


	
	

}
