package interation01;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import iteration01.fr.agh.domain.Cell;
import iteration01.fr.agh.domain.Grid;
import iteration01.fr.agh.domain.State;

public class GridTest {

	private Grid gridWithOneAliveCell;
	private Grid gridWithOneDEADCell;

	private Grid targetGrid;

	@Before
	public void setUp() throws Exception {
		
		Cell aliveCell = new Cell(State.ALIVE);
		Cell deadCell = new Cell(State.DEAD);

		gridWithOneAliveCell = new Grid(aliveCell);
		gridWithOneDEADCell = new Grid(deadCell);

		Cell targetCell = new Cell(State.DEAD);

		targetGrid = new Grid(targetCell);

	}

	@Test
	public void should_Return_DEADState_After_Current_ALIVEState() {
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneAliveCell.newState());

	}

	@Test
	public void should_Return_DEADState_After_Current_DEADState() {
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneDEADCell.newState());
	}

	@Test
	public void should_Return_A_Grid_With_A_DEAD_Cell_After_Current_ALIVEState() {
		gridWithOneAliveCell.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithOneAliveCell);
	}

	@Test
	public void should_Return_A_Grid_With_A_DEAD_Cell_After_CurrentDEADState() {
		gridWithOneDEADCell.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithOneDEADCell);
	}

}
