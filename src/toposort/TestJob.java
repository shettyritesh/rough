package toposort;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJob {

	@Test
	public void testPrintSequence() {
		Job job = new Job();
		job.addDependency("A", "B");
		job.addDependency("B", "C");
		job.addDependency("B", "E");
		job.addDependency("E", "D");
		job.addDependency("C", "D");
		job.addDependency("O", "C");
		job.printSequence();
	}

}
