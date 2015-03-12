package hashcode;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		final InputReader reader = new InputReader();
		reader.readFromFile("dc.in", new IdGenerator());
	}

}
