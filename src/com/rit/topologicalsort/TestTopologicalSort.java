package com.rit.topologicalsort;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTopologicalSort {

	@Test
	public void testPrintDependencies() {
		TaskExecutor executor = new TaskExecutor();
		executor.addDependency("1", "3");
		executor.addDependency("1", "7");
		executor.addDependency("1", "4");
		executor.addDependency("4", "6");
		executor.addDependency("4", "5");
		executor.addDependency("3", "4");
		executor.addDependency("6", "5");
		executor.addDependency("7", "5");
		executor.addDependency("8", "9");
		executor.printDependencies();
	}

}
