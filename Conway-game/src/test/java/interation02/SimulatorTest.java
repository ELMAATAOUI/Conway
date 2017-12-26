package interation02;

import org.junit.Before;
import org.junit.Test;

import iteration02.fr.agh.domain.Cell;
import iteration02.fr.agh.domain.Grid;
import iteration02.fr.agh.domain.State;

public class SimulatorTest {
	private Grid grid;

	@Before
	public void setUp() {
		Cell firstCell = new Cell(State.ALIVE);
		Cell secondCell = new Cell(State.ALIVE);

		this.grid = new Grid(firstCell, secondCell);
	}

	@Test
	public void should_Return_New_DEADState() {

		// Assertions.assertThat(State.DEAD).isEqualTo(grid.newState(cell));
	}

}
