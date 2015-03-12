package data;

/**
 * A data center are divided in rows, for the physical servers. It is also
 * divided in logicals pools used for the capacity of the servers.
 * 
 * @author leo
 *
 */
public class DataCenter
{
	/**
	 * The rows of the data center
	 */
	protected Row[] rows;
	
	/**
	 * The pools of the data center
	 */
	protected Pool[] pools;
	
	public DataCenter(int nrows, int npools)
	{
		Row[] r = new Row[nrows];
		Pool[] p = new Pool[npools];
		this.setRows(r);
		this.setPools(p);
	}
	
	public Row[] getRows()
	{
		return this.rows;
	}
	
	public void setRows(Row[] rows)
	{
		if (rows.length < 1 || rows.length > 1000)
			throw new IllegalArgumentException("The number of rows must be between 1 and 1000");
		
		this.rows = rows;
	}
	
	public Pool[] getPools()
	{
		return this.pools;
	}
	
	public void setPools(Pool[] pools)
	{
		if (rows.length < 1 || rows.length > 1000)
			throw new IllegalArgumentException("The number of pools must be between 1 and 1000");
	
		this.pools = pools;
	}
}
