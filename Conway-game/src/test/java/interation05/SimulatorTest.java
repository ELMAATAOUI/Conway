package interation05;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import iteration05.fr.agh.domain.Grid;
import iteration05.fr.agh.domain.State;

public class SimulatorTest {
	private Grid grid;

	@Before
	public void setUp() {
		
	}

	@Test
	public void should_Return_New_DEADState() {

		 Assertions.assertThat(State.DEAD).isEqualTo(State.DEAD);
	}

}
