package interation01;

import org.junit.Before;
import org.junit.Test;

import iteration01.fr.agh.domain.Cell;
import iteration01.fr.agh.domain.Grid;
import iteration01.fr.agh.domain.State;




public class SimulatorTest {
	private Grid grid;
	private Cell cell;
	@Before
	public void setUp() {
		
		this.cell= new Cell(State.ALIVE);
		this.grid=new Grid(cell);
	}

	@Test
	public void should_Return_New_DEADState() {
		
	//	Assertions.assertThat(State.DEAD).isEqualTo(grid.newState(cell));
	}

	

}
