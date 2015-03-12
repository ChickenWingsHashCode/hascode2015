package hashcode;

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

}
