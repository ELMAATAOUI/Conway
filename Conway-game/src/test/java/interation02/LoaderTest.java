package interation02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import iteration02.Simulator;
import iteration02.fr.agh.domain.Cell;
import iteration02.fr.agh.domain.Dimension;
import iteration02.fr.agh.domain.Grid;
import iteration02.fr.agh.domain.State;
import iteration02.fr.agh.services.FileLoadingService;
import iteration02.fr.agh.services.LoadingService;


public class LoaderTest {
	private LoadingService loader;
	private Simulator targetSimulator;
	private Simulator targetSimulatorWithNullCell;

	@Before
	public void setUp() {

		Cell firstCell = new Cell(State.ALIVE);
		Cell secondCell = new Cell(State.DEAD);
		
		Grid grid = new Grid(firstCell,secondCell);
		Grid gridWithNullCell=new Grid(firstCell);
		
		this.targetSimulator = new Simulator(new Dimension(1, 2), 3, grid);
		
		this.targetSimulatorWithNullCell= new Simulator(new Dimension(1, 1), 3, gridWithNullCell);
	}

	@Test
	public void should_Return_TargetSimulator() {
		String dataFileName = getClass().getResource("/iteration02/data").getPath();
		loader = new FileLoadingService(dataFileName);
		Simulator simulator = loader.load();
		assertThat(this.targetSimulator).isEqualTo(simulator);
	}
	@Test
	public void should_Return_targetSimulatorWithNullCell() {
		String dataFileName = getClass().getResource("/iteration02/data01").getPath();
		loader = new FileLoadingService(dataFileName);
		Simulator simulator = loader.load();

		assertThat(this.targetSimulatorWithNullCell).isEqualTo(simulator);
	}

}
