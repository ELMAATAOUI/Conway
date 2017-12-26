package interation05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import iteration05.Simulator;
import iteration05.fr.agh.domain.Cell;
import iteration05.fr.agh.domain.Dimension;
import iteration05.fr.agh.domain.Grid;
import iteration05.fr.agh.domain.State;
import iteration05.fr.agh.services.FileLoadingService;
import iteration05.fr.agh.services.LoadingService;

public class LoaderTest {
	private LoadingService loader;
	private Simulator targetOneSevenSimulator;
	private Simulator targetOneTwoSimulator;
	private Simulator targetOneOneSimulator;
	private Simulator targetSevenOneSimulator;

	private Simulator targetSevenForSimulator;

	@Before
	public void setUp() {

		Cell c00 = new Cell(State.ALIVE);
		Cell[][] cells00 = { { c00 } };

		Grid grid00 = new Grid(cells00);

		this.targetOneOneSimulator = new Simulator(new Dimension(1, 1), 3, grid00);

		Cell c001 = new Cell(State.ALIVE);
		Cell c002 = new Cell(State.DEAD);
		Cell[][] cells01 = { { c001, c002 } };

		Grid grid01 = new Grid(cells01);

		this.targetOneTwoSimulator = new Simulator(new Dimension(1, 2), 3, grid01);

		Cell c01 = new Cell(State.ALIVE);
		Cell c02 = new Cell(State.DEAD);
		Cell c03 = new Cell(State.ALIVE);
		Cell c04 = new Cell(State.ALIVE);
		Cell c05 = new Cell(State.ALIVE);
		Cell c06 = new Cell(State.ALIVE);
		Cell c07 = new Cell(State.ALIVE);
		Cell[][] cells02 = { { c01, c02, c03, c04, c05, c06, c07 } };

		Grid grid02 = new Grid(cells02);

		this.targetOneSevenSimulator = new Simulator(new Dimension(1, 7), 3, grid02);

		Cell c011 = new Cell(State.ALIVE);
		Cell c022 = new Cell(State.DEAD);
		Cell c033 = new Cell(State.ALIVE);
		Cell c044 = new Cell(State.ALIVE);
		Cell c055 = new Cell(State.ALIVE);
		Cell c066 = new Cell(State.ALIVE);
		Cell c077 = new Cell(State.ALIVE);
		Cell[][] cells03 = { { c011 }, { c022 }, { c033 }, { c044 }, { c055 }, { c066 }, { c077 } };

		Grid grid03 = new Grid(cells03);

		this.targetSevenOneSimulator = new Simulator(new Dimension(7, 1), 3, grid03);
		
		
		Cell[][] cells04 = { { c011,c022,c033,c044 }, 
				{ c022,c022,c033,c044  },
				{ c033,c022,c033,c044  },
				{ c044 ,c022,c033,c044 },
				{ c055,c022,c033,c044  },
				{ c066 ,c022,c033,c044 },
				{ c077,c022,c033,c044  } };
		
		Grid grid04 = new Grid(cells04);

		this.targetSevenForSimulator = new Simulator(new Dimension(7, 4), 3, grid04);
	}

	private LoadingService createLoader(String fileName) {
		String dataFileName = getClass().getResource(fileName).getPath();
		loader = new FileLoadingService(dataFileName);
		return loader;
	}

	@Test
	public void should_Return_targetOneOneSimulator() {
		// given
		loader = this.createLoader("/iteration05/data01");

		// when
		Simulator simulator = loader.load();

		// then
		assertThat(this.targetOneOneSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_targetOneTwoSimulator() {
		// given
		loader = this.createLoader("/iteration05/data02");

		// when
		Simulator simulator = loader.load();

		// then
		assertThat(this.targetOneTwoSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_targetOneSevenSimulator() {
		// given
		loader = this.createLoader("/iteration05/data03");

		// when
		Simulator simulator = loader.load();

		// then
		assertThat(this.targetOneSevenSimulator).isEqualTo(simulator);
	}

	@Test
	public void should_Return_targetSevenOneSimulator() {
		// given
		loader = this.createLoader("/iteration05/data04");

		// when
		Simulator simulator = loader.load();

		// then
		assertThat(this.targetSevenOneSimulator).isEqualTo(simulator);
	}
	@Test
	public void should_Return_targetSevenForSimulator() {
		// given
		loader = this.createLoader("/iteration05/data");

		// when
		Simulator simulator = loader.load();

		// then
		assertThat(this.targetSevenForSimulator).isEqualTo(simulator);
	}

}
