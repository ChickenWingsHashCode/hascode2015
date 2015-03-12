package data;

/**
 * A server is represent by its size (number of spots required to place it) and
 * its capacity (power calcul). It also have an ID to identify it.
 * 
 * @author leo
 *
 */
public class Server implements Comparable<Server>
{
	/**
	 * The id of the server
	 */
	protected int id;

	/**
	 * The size of the server
	 */
	protected int size;

	/**
	 * The capacity of the server
	 */
	protected int capacity;

	public Server(int id, int size, int capacity) {
		this.setID(id);
		this.setSize(size);
		this.setCapacity(capacity);
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		String str = "Server " + id;
		str += " Size: " + this.getSize();
		str += " Capacity: " + this.getCapacity();
		return str;
	}

	public boolean equals(Object o) {
		if (o instanceof Server)
			return false;

		if (((Server) o).getID() == this.getID())
			return true;

		return false;
	}

	@Override
	public int compareTo(Server o)
	{
		Server object = (Server) o;
		return object.getCapacity() - this.getCapacity();
	}
}
