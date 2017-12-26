package interation01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import iteration01.Simulator;
import iteration01.fr.agh.domain.Cell;
import iteration01.fr.agh.domain.Grid;
import iteration01.fr.agh.domain.State;
import iteration01.fr.agh.services.FileLoadingService;
import iteration01.fr.agh.services.LoadingService;


public class LoaderTest {
	private LoadingService loader;
	private Simulator targetSimulator;

	@Before
	public void setUp() {

		String dataFileName = getClass().getResource("/iteration01/data").getPath();
		loader = new FileLoadingService(dataFileName);

		Cell cell = new Cell(State.ALIVE);
		Grid grid = new Grid(cell);

		this.targetSimulator = new Simulator(1, 12, grid);
	}

	@Test
	public void should_Return_Target_Simulator() {
		Simulator simulator = loader.load();

		assertThat(this.targetSimulator).isEqualTo(simulator);
	}

}
