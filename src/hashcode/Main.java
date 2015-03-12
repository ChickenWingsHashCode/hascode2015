package hashcode;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		final InputReader reader = new InputReader();
		final ProblemSolver solver = reader.readFromFile("dc.in", new IdGenerator());
		solver.initPools();
	}

}
