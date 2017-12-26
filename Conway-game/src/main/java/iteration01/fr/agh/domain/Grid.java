package iteration01.fr.agh.domain;
/**
 * @author elm
 *
 */
public class Grid {
		
	private Cell cell;

	
	public Grid() {
		super();
	}


	public Grid(Cell cell) {
		super();
		this.cell = cell;
	}
	
	
	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public State newState() {
		return State.DEAD;
	}

	public void evolution() {
		this.cell.setState(newState());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
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
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grid [cell=" + cell + "]";
	}
	
	

}
