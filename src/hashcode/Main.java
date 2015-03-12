package hashcode;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		final InputReader reader = new InputReader();
		final ProblemSolver solver = reader.readFromFile("input.txt", new IdGenerator());
		try
		{
			solver.initPools();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
