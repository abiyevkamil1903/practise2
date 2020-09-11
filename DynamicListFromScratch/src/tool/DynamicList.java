package tool;

import static java.lang.System.out;

public class DynamicList<E> 
{
	private Object[] items;
	private int size;
	
	public DynamicList()
	{	
		this(10);
	}
	public DynamicList(int initialCapacity)
	{	
		if(initialCapacity > 0)
		{
			this.items = new Object[initialCapacity];
		}else if(initialCapacity == 0) {
			this.items = new Object[10];
		}else {
			throw new IllegalArgumentException("Illegal capacity");
		}
	}
	public int size()
	{
		return size;
	}
	
	public void print()
	{
		for(int i = 0; i < size; i++)
		{
			out.print(items[i] + " ");
		}
	}
	
	public DynamicList<E> add(E item)
	{
		if(this.size == this.items.length)
		{
			int oldCapacity = this.items.length;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			
			Object[] newItems = new Object[newCapacity];
			
			for(int i = 0; i < size; i++)
				newItems[i] = this.items[i];
			
			this.items = newItems;
		}
		items[size++] = item;
		return this;
	}
	
}
