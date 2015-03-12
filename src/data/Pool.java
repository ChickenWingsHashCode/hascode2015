package data;

import java.util.HashSet;
import java.util.Set;

/**
 * A pool is a set of servers than share ressources.
 * 
 * @author leo
 *
 */
public class Pool
{
	/**
	 * The servers of the pool
	 */
	protected Set<Server> servers;

	public Pool()
	{
		this.servers = new HashSet<Server>();
	}

	public Set<Server> getServers()
	{
		return this.servers;
	}

	/**
	 * Add a server to the pool
	 * 
	 * @param server
	 */
	public void addServer(Server server)
	{
		this.servers.add(server);
	}

	/**
	 * Remove the server of the pool
	 * 
	 * @param server
	 */
	public void removeServer(Server server)
	{
		this.servers.remove(server);
	}
	
	public int totalCapacity()
	{
		int res = 0;
		for (Server s : this.getServers())
		{
			res += s.getCapacity();
		}
		return res;
	}
	
	public String toString()
	{
		String str = "Pool:\n" + this.getServers();
		str += "\nCapacity = " + this.totalCapacity();
		return str;
	}
}
