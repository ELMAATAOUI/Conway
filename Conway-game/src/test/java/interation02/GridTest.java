package interation02;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import iteration02.fr.agh.domain.Cell;
import iteration02.fr.agh.domain.Grid;
import iteration02.fr.agh.domain.State;

public class GridTest {

	private Grid gridWithOneAliveANdOneDeadCell;
	private Grid gridWithTwoDEADCells;
	private Grid gridWithOneAliveANdONullCell;

	private Grid targetGrid;

	@Before
	public void setUp() throws Exception {

		gridWithOneAliveANdOneDeadCell = new Grid(new Cell(State.ALIVE), new Cell(State.DEAD));
		gridWithTwoDEADCells = new Grid(new Cell(State.DEAD), new Cell(State.DEAD));
		gridWithOneAliveANdONullCell=new Grid(new Cell(State.DEAD), null);
		Cell targetFirstCell = new Cell(State.DEAD);
		Cell targetSecondCell = new Cell(State.DEAD);

		targetGrid = new Grid(targetFirstCell, targetSecondCell);

	}

	@Test
	public void should_Return_DEADState_from_gridWithOneAliveANdOneDeadCell() {

		Cell fCell = gridWithOneAliveANdOneDeadCell.getFirstCell();
		Cell sCell = gridWithOneAliveANdOneDeadCell.getSecondCell();
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneAliveANdOneDeadCell.newState(fCell));
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneAliveANdOneDeadCell.newState(sCell));

	}
	@Test
	public void should_Return_DEADState_from_gridWithOneAliveANdONullCell() {

		Cell fCell = gridWithOneAliveANdONullCell.getFirstCell();
		Cell sCell = gridWithOneAliveANdONullCell.getSecondCell();
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneAliveANdONullCell.newState(fCell));
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithOneAliveANdONullCell.newState(sCell));

	}

	@Test
	public void should_Return_DEADState_From_gridWithTwoDEADCells() {
		Cell fCell = gridWithTwoDEADCells.getFirstCell();
		Cell sCell = gridWithTwoDEADCells.getSecondCell();
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithTwoDEADCells.newState(fCell));
		Assertions.assertThat(State.DEAD).isEqualTo(gridWithTwoDEADCells.newState(sCell));
	}

	@Test
	public void should_Return_A_Grid_With_DEAD_Cells_from_gridWithOneAliveANdOneDeadCell() {
		gridWithOneAliveANdOneDeadCell.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithOneAliveANdOneDeadCell);
	}

	@Test
	public void should_Return_A_Grid_With_A_DEAD_Cells_From_gridWithTwoDEADCells() {
		gridWithTwoDEADCells.evolution();

		Assertions.assertThat(targetGrid).isEqualTo(gridWithTwoDEADCells);
	}

}
