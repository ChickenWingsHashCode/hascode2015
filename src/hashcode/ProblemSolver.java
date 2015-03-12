package hashcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.*;

/**
 * Class to solve the problem of optimization of capacity for a data center
 * 
 * @author leo
 *
 */
public class ProblemSolver
{
	/**
	 * The data center
	 */
	protected DataCenter datacenter;

	/**
	 * The rows
	 */
	protected Row[] rows;

	/**
	 * The pools
	 */
	protected Pool[] pools;

	/**
	 * The servers
	 */
	protected Set<Server> servers;

	public ProblemSolver(DataCenter datacenter, Set<Server> servers)
	{
		this.setDatacenter(datacenter);
		this.setRows(datacenter.getRows());
		this.setPools(datacenter.getPools());
		this.setServers(servers);
	}

	public DataCenter getDatacenter()
	{
		return this.datacenter;
	}

	public void setDatacenter(DataCenter datacenter)
	{
		this.datacenter = datacenter;
	}

	public Row[] getRows()
	{
		return this.rows;
	}

	public void setRows(Row[] rows)
	{
		this.rows = rows;
	}

	public Pool[] getPools()
	{
		return this.pools;
	}

	public void setPools(Pool[] pools)
	{
		this.pools = pools;
	}

	public Set<Server> getServers()
	{
		return this.servers;
	}

	public void setServers(Set<Server> servers)
	{
		this.servers = servers;
	}

	/**
	 * Create the potential ideal pools
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void initPools() throws Exception
	{
		List<Server> s = new ArrayList<Server>();
		s.addAll(this.getServers());
		Collections.sort(s);
		
		Pool[] p = this.getPools();
		int i = 0;
		boolean pos = true;
		for (Server ser: s)
		{
			p[i].addServer(ser);
			if (pos && i < p.length)
				i++;
			else if (pos && i >= p.length)
				pos = false;
			else if (!pos && i >= 1)
				i--;
			else if (!pos &&i < 1)
				pos = true;
			else
				throw new Exception();
		}
		
		for (int j = 0; j < p.length; i++)
		{
			System.out.println(p[j]);
		}
	}
}
