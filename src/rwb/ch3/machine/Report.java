package rwb.ch3.machine;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class Report {
	public static void report(Writer out, List<Machine> machines, Robot robot) throws IOException {
		out.write("FACTORY REPORT\n");

		Iterator<Machine> line = machines.iterator();
		while (line.hasNext()) {
			Machine machine = line.next();
			out.write("Machine " + machine.name());

			if (machine.bin() != null)
				out.write(" bin=" + machine.bin());

			out.write("\n");
		}
		out.write("\n");

		out.write("Robot");
		if (robot.location() != null)
			out.write(" location=" + robot.location().name());

		if (robot.bin() != null)
			out.write(" bin=" + robot.bin());

		out.write("\n");

		out.write("========\n");
	}
}