package demos;

import iteration01.Simulator;
import iteration01.fr.agh.services.ConsolePrintService;
import iteration01.fr.agh.services.FileLoadingService;

/**
 * @author elm
 *
 */
public class Demo {
	
	public Demo() {

	}
	public void exp01() {
		String dataFileName = getClass().getResource("/iterations01/data").getPath();
		Simulator simulator=new FileLoadingService(dataFileName).load();
		simulator.setPrintService(new ConsolePrintService());
		simulator.start();
	}
	public void exp02() {
		String dataFileName = getClass().getResource("/iterations02/data").getPath();
		iteration02.Simulator simulator=new iteration02.fr.agh.services.FileLoadingService(dataFileName).load();
		simulator.setPrintService(new iteration02.fr.agh.services.ConsolePrintService());
		simulator.start();
	}
	public void exp03() {
		String dataFileName = getClass().getResource("/iterations03/data").getPath();
		iteration03.Simulator simulator=new iteration03.fr.agh.services.FileLoadingService(dataFileName).load();
		simulator.setPrintService(new iteration03.fr.agh.services.ConsolePrintService());
		simulator.start();
	}
	public void exp04() {
		String dataFileName = getClass().getResource("/iterations04/data").getPath();
		iteration04.Simulator simulator=new iteration04.fr.agh.services.FileLoadingService(dataFileName).load();
		simulator.setPrintService(new iteration04.fr.agh.services.ConsolePrintService());
		simulator.start();
	}
	
	public void exp05() {
		String dataFileName = getClass().getResource("/iterations05/data").getPath();
		iteration05.Simulator simulator=new iteration05.fr.agh.services.FileLoadingService(dataFileName).load();
		simulator.setPrintService(new iteration05.fr.agh.services.ConsolePrintService());
		simulator.start();
	}
	
	public void test(String fileName) {
		
		String dataFileName = getClass().getResource(fileName).getPath();
		iteration05.Simulator simulator=new iteration05.fr.agh.services.FileLoadingService(dataFileName).load();
		simulator.setPrintService(new iteration05.fr.agh.services.ConsolePrintService());
		simulator.start();
	}
	
	public static void main(String[] args) {
		new Demo().test("/demos/clown");
	}

}
