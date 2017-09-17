package rwb.ch3.machine;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Report {
	private Writer out;

	public Report(Writer out) {
		this.out = out;
	}

	public void report(List<Machine> machines, Robot robot) throws IOException {
		reportHeader();
		reportMachines(machines);
		reportRobot(robot);
		reportFooter();
	}

	private void reportHeader() throws IOException {
		out.write("FACTORY REPORT\n");
	}

	private void reportRobot(Robot robot) throws IOException {
		reportRobotHeader();
		reportRobotLocation(robot);
		reportRobotBin(robot);
		reportRobotFooter();
	}

	private void reportRobotHeader() throws IOException {
		out.write("Robot");
	}

	private void reportRobotLocation(Robot robot) throws IOException {
		if (robot.location() != null)
			out.write(" location=" + robot.location().name());
	}

	private void reportRobotBin(Robot robot) throws IOException {
		if (robot.bin() != null)
			out.write(" bin=" + robot.bin());
	}

	private void reportRobotFooter() throws IOException {
		writeNewline();
	}

	private void reportMachines(List<Machine> machines) throws IOException {
		reportAllMachines(machines);
		reportMachinesFooter();
	}

	private void reportAllMachines(List<Machine> machines) throws IOException {
		for (Machine machine : machines) {
			reportSingleMachine(machine);
		}
	}

	private void reportSingleMachine(Machine machine) throws IOException {
		reportMachineName(machine);
		reportMachineBin(machine);
		reportMachineFooter();
	}

	private void reportMachineName(Machine machine) throws IOException {
		out.write("Machine " + machine.name());
	}

	private void reportMachineBin(Machine machine) throws IOException {
		if (machine.bin() != null)
			out.write(" bin=" + machine.bin());
	}

	private void reportMachineFooter() throws IOException {
		writeNewline();
	}

	private void reportMachinesFooter() throws IOException {
		writeNewline();
	}

	private void reportFooter() throws IOException {
		out.write("========\n");
	}

	private void writeNewline() throws IOException {
		out.write("\n");
	}
}