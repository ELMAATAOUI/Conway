package iteration01.fr.agh.domain;

/**
 * @author elm
 *
 */
public class Cell {

	private State state;

	public Cell() {
		super();
		this.state = State.DEAD;
	}

	public Cell(State state) {
		super();
		this.state = state;
	}


	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isAlive() {
		return State.ALIVE.equals(this.state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [state=" + state + "]";
	}

}
