package data.utils;

public class Bloc
{
	/**
	 * The slot at the beginning
	 */
	protected int start;

	/**
	 * The slot at the end
	 */
	protected int size;

	public Bloc(int start, int end)
	{
		this.start = start;
		this.size = end - start + 1;
	}
	
	public int getStart()
	{
		return this.start;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void update(int size)
	{
		this.start += size;
		this.size -= size;
	}
}
