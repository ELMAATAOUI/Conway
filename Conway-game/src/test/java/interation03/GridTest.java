package interation03;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import iteration03.fr.agh.domain.Cell;
import iteration03.fr.agh.domain.Grid;
import iteration03.fr.agh.domain.State;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GridTest {

	private Grid sourceOneOneGrid;
	private Grid sourceOneTwoGrid;
	private Grid sourceOneSevenGrid;

	private Grid targetOneOneGrid;
	private Grid targetOneTwoGrid;
	private Grid targetOneSevenGrid;

	@Before
	public void setUp() throws Exception {

		// source
		Cell c00 = new Cell(State.ALIVE);
		Cell[] cells00 = { c00 };

		this.sourceOneOneGrid = new Grid(cells00);

		// target
		Cell c00T = new Cell(State.DEAD);
		Cell[] cells00T = { c00T };

		this.targetOneOneGrid = new Grid(cells00T);

		// source
		Cell c001 = new Cell(State.ALIVE);
		Cell c002 = new Cell(State.DEAD);
		Cell[] cells01 = { c001, c002 };

		this.sourceOneTwoGrid = new Grid(cells01);

		// target
		Cell c001T = new Cell(State.DEAD);
		Cell c002T = new Cell(State.DEAD);
		Cell[] cells01T = { c001T, c002T };

		this.targetOneTwoGrid = new Grid(cells01T);

		// source
		Cell c01 = new Cell(State.ALIVE);
		Cell c02 = new Cell(State.DEAD);
		Cell c03 = new Cell(State.ALIVE);
		Cell c04 = new Cell(State.ALIVE);
		Cell c05 = new Cell(State.ALIVE);
		Cell c06 = new Cell(State.ALIVE);
		Cell c07 = new Cell(State.ALIVE);
		Cell[] cells02 = { c01, c02, c03, c04, c05, c06, c07 };

		this.sourceOneSevenGrid = new Grid(cells02);

		// target
		Cell c01T = new Cell(State.DEAD);
		Cell c02T = new Cell(State.DEAD);
		Cell c03T = new Cell(State.DEAD);
		Cell c04T = new Cell(State.ALIVE);
		Cell c05T = new Cell(State.ALIVE);
		Cell c06T = new Cell(State.ALIVE);
		Cell c07T = new Cell(State.DEAD);
		Cell[] cells02T = { c01T, c02T, c03T, c04T, c05T, c06T, c07T };

		this.targetOneSevenGrid = new Grid(cells02T);

	}

	@Test
	public void should1_Return_DEADState_from_sourceOneOneGrid() {

		Cell cell = sourceOneOneGrid.getCells()[0];

		Assertions.assertThat(State.DEAD).isEqualTo(sourceOneOneGrid.newState(0));

	}

	@Test
	public void should2_Return_DEADState_from_sourceOneTwoGrid() {

		Cell cell = sourceOneTwoGrid.getCells()[0];

		Assertions.assertThat(State.DEAD).isEqualTo(sourceOneTwoGrid.newState(0));

	}

	@Test
	public void should3_Return_ALIVEState_From_sourceOneSevenGridCell4() {
		Cell cell = sourceOneSevenGrid.getCells()[4];

		Assertions.assertThat(State.ALIVE).isEqualTo(sourceOneSevenGrid.newState(4));
	}

	@Test
	public void should4_Return_DEADState_From_sourceOneSevenGridCell6() {
		Cell cell = sourceOneSevenGrid.getCells()[6];

		Assertions.assertThat(State.DEAD).isEqualTo(sourceOneSevenGrid.newState(6));
	}

	@Test
	public void should5_Return_targetOneOneGrid_from_sourceOneOneGrid() {
		sourceOneOneGrid.evolution();

		Assertions.assertThat(sourceOneOneGrid).isEqualTo(targetOneOneGrid);
	}
	
	@Test
	public void should5_Return_targetOneTwoGrid_from_sourceOneTwoGrid() {
		sourceOneTwoGrid.evolution();

		Assertions.assertThat(sourceOneTwoGrid).isEqualTo(targetOneTwoGrid);
	}

	@Test
	public void should6_Return_targetOneSevenGrid_from_sourceOneSevenGrid() {
		sourceOneSevenGrid.evolution();

		Assertions.assertThat(sourceOneSevenGrid).isEqualTo(targetOneSevenGrid);
	}

}
