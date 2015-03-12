package hashcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import data.Row;
import data.Server;

public class InputReader {

	private static final String SEPARATOR = " ";

	public DataCenter readFromFile(String filename, IdGenerator idGenerator)
			throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(
				filename));
		String currentLine = null;
		currentLine = reader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(currentLine, " ");
		// first line
		final DataCenter dataCenter = new DataCenter();
		final int nbRows = Integer.parseInt(tokenizer.nextToken());
		final Row[] rows = new Row[nbRows];
		final int nbSlotsPerRow = Integer.parseInt(tokenizer.nextToken());
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new Row(nbSlotsPerRow);
		}
		final int nbUnavailableLocations = Integer.parseInt(tokenizer
				.nextToken());
		final int nbGroups = Integer.parseInt(tokenizer.nextToken());
		final int nbServers = Integer.parseInt(tokenizer.nextToken());
		System.out.println("Nombre de rangées : " + nbRows);
		System.out.println("Nombre d'emplacements par rangée : "
				+ nbSlotsPerRow);
		System.out.println("Nombre d'emplacements indisponibles : "
				+ nbUnavailableLocations);
		System.out.println("Nombre de groupes : " + nbGroups);
		System.out.println("Nombre de serveurs à allouer : " + nbServers);
		// unavailable locations
		final List<Position> unavailableLocations = new LinkedList<Position>();
		System.out.println("Emplacements indisponibles :");
		for (int i = 0; i < nbUnavailableLocations; i++) {
			currentLine = reader.readLine();
			tokenizer = new StringTokenizer(currentLine, SEPARATOR);
			final int x = Integer.parseInt(tokenizer.nextToken());
			final int y = Integer.parseInt(tokenizer.nextToken());
			final Position position = new Position(x, y);
			System.out.println("  - " + position);
			unavailableLocations.add(position);
		}
		// servers
		System.out.println("Serveurs :");
		final List<Server> servers = new LinkedList<Server>();
		for (int i = 0; i < nbServers; i++) {
			currentLine = reader.readLine();
			tokenizer = new StringTokenizer(currentLine, SEPARATOR);
			final int size = Integer.parseInt(tokenizer.nextToken());
			final int capacity = Integer.parseInt(tokenizer.nextToken());
			final Server server = new Server(idGenerator.getNextId(), size,
					capacity);
			System.out.println(server);
			servers.add(server);
		}
		reader.close();
		return null;

	}

}
