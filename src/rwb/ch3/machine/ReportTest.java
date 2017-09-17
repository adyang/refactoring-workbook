package rwb.ch3.machine;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReportTest {
	@Test
	public void testReport() throws IOException {
		List<Machine> line = new ArrayList<>();
		line.add(new Machine("mixer", "left"));

		Machine extruder = new Machine("extruder", "center");
		extruder.put("paste");
		line.add(extruder);

		Machine oven = new Machine("oven", "right");
		oven.put("chips");
		line.add(oven);

		Robot robot = new Robot();
		robot.moveTo(extruder);
		robot.pick();

		StringWriter out = new StringWriter();
		new Report(out).report(line, robot);

		String expected = "FACTORY REPORT\n" + "Machine mixer\nMachine extruder\n" + "Machine oven bin=chips\n\n"
				+ "Robot location=extruder bin=paste\n" + "========\n";

		assertEquals(expected, out.toString());
	}
}
