package hashcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import data.DataCenter;
import data.Pool;
import data.Row;
import data.Server;

public class InputReader {

	private static final String SEPARATOR = " ";

	public ProblemSolver readFromFile(String filename, IdGenerator idGenerator)
			throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(
				filename));
		String currentLine = null;
		currentLine = reader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(currentLine, " ");
		// first line
		final int nbRows = Integer.parseInt(tokenizer.nextToken());
		final Row[] rows = new Row[nbRows];
		final int nbSlotsPerRow = Integer.parseInt(tokenizer.nextToken());
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row(nbSlotsPerRow);
		}
		final int nbUnavailableSlots = Integer.parseInt(tokenizer
				.nextToken());
		final int nbGroups = Integer.parseInt(tokenizer.nextToken());
		final int nbServers = Integer.parseInt(tokenizer.nextToken());
		// unavailable locations
		for (int i = 0; i < nbUnavailableSlots; i++) {
			currentLine = reader.readLine();
			tokenizer = new StringTokenizer(currentLine, SEPARATOR);
			final int x = Integer.parseInt(tokenizer.nextToken());
			final int y = Integer.parseInt(tokenizer.nextToken());
			final Row concernedRow = rows[x];
			concernedRow.getSlots()[y].setUnavailable(true);
		}
		// servers
		final Set<Server> servers = new HashSet<Server>();
		for (int i = 0; i < nbServers; i++) {
			currentLine = reader.readLine();
			tokenizer = new StringTokenizer(currentLine, SEPARATOR);
			final int size = Integer.parseInt(tokenizer.nextToken());
			final int capacity = Integer.parseInt(tokenizer.nextToken());
			final Server server = new Server(idGenerator.getNextId(), size,
					capacity);
			servers.add(server);
		}
		final Pool[] pools = new Pool[nbGroups];
		for (int i = 0 ; i < pools.length ; i++) {
			pools[i] = new Pool();
		}
		final DataCenter dataCenter = new DataCenter(rows, pools);
		reader.close();
		return new ProblemSolver(dataCenter, servers);

	}

}
