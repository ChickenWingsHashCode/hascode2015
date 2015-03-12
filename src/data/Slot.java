package data;

/**
 * A slot can be occupied by a server. A slot can be unavailable
 * 
 * @author leo
 *
 */
public class Slot {
	/**
	 * The server on the spot if it exists
	 */
	protected Server server;

	/**
	 * If a slot is unavailable
	 */
	protected boolean unavailable;

	public Slot(boolean unvailable) {
		this.setServer(null);
		this.setUnavailable(unvailable);
	}

	public Server getServer() {
		if (this.server == null)
			throw new IllegalStateException("The slot is empty");

		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void setUnavailable(boolean unavailable) {
		this.unavailable = unavailable;
	}

	/**
	 * @return true if the server is unavailable
	 */
	public boolean isUnaivalable() {
		return this.unavailable;
	}

}
