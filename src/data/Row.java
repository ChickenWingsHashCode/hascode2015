package data;

import java.util.ArrayList;
import java.util.List;

import data.utils.Bloc;

/**
 * A row is composed of several spots for servers. Some spots might be
 * unavailable. A server take a number of spots equals to its size.
 * 
 * @author leo
 *
 */
public class Row
{
	/**
	 * The number of slots of the row. Include the unavailable slots too.
	 */
	protected int size;

	/**
	 * The slots of the server
	 */
	protected Slot[] slots;

	/**
	 * The number of unavailable slots
	 */
	protected int unavailable;

	/**
	 * Blocs available
	 */
	protected List<Bloc> blocs;

	/**
	 * Create a new row of <i>size</i> slots
	 * 
	 * @param size
	 */
	public Row(int size)
	{
		Slot[] s = new Slot[size];
		for (int i = 0; i < size; i++)
		{
			s[i] = new Slot(false);
		}
		this.setSlots(s);
		this.countUnavailable();
	}

	public int getSize()
	{
		return this.size;
	}

	public Slot[] getSlots()
	{
		return this.slots;
	}

	protected void setSlots(Slot[] slots)
	{
		if (slots.length < 1 || slots.length > 1000)
			throw new IllegalArgumentException(
					"Number of slots must be contains between 0 and 1000");

		this.slots = slots;
	}
	
	public int getUnavailable()
	{
		return this.unavailable;
	}

	protected void setUnaivalable(int n)
	{
		this.unavailable = n;
	}

	protected void countUnavailable()
	{
		int count = 0;
		Slot[] s = this.getSlots();
		for (int i = 0; i < s.length; i++)
		{
			if (s[i].isUnaivalable()) count++;
		}

		this.setUnaivalable(count);
	}
	
	public void addServer(Server server, Bloc bloc)
	{
		int s = bloc.getStart();
		for (int i = s; i < server.getSize(); i++)
		{
			this.getSlots()[i].setServer(server);
		}
		this.updateBlocs(bloc, server);
	}

	public void initBlocs()
	{
		this.blocs = new ArrayList<Bloc>();
		Bloc bloc;
		int start = 0;
		for (int i = 0; i < this.getSlots().length; i++)
		{
			if (this.getSlots()[i].isUnaivalable())
			{
				bloc = new Bloc(start, i - 1);
				if (i != this.getSlots().length) start = i + 1;
				this.blocs.add(bloc);
			}
		}
	}
	
	public void updateBlocs(Bloc bloc, Server server)
	{
		int size = server.getSize();
		bloc.update(size);
		if (bloc.getSize() <= 0)
			this.blocs.remove(bloc);
	}
}
