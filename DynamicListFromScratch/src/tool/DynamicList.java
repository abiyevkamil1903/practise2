package tool;

import static java.lang.System.out;

import java.util.Arrays;

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
	
	@Override
	public String toString() {
		String result = "[";
		int i;
		for (i = 0; i < this.size - 1; i++)
		{
			result += this.items[i] + ", ";
		}
		result += this.items[i] + "]";
		return result;
	}
	
	public E get(int index)
	{
		if(index >= this.size)
			throw new ArrayIndexOutOfBoundsException(index);
		
		return (E)this.items[index];
	}
	
	public DynamicList<E> set(int index, E item)
	{
		if(index < 0 || index >= this.size)
			return this;
		this.items[index] = item;
		return this;
	}
	public 	DynamicList<E> removeAt(int index)
	{
		if (index >= this.size)
			throw new ArrayIndexOutOfBoundsException(index);
		for(int i = index; i < this.size - 1; i++)
			this.items[i] = this.items[i + 1];
		
		this.size--;
		
		return this;
	}
	
	public DynamicList<E> remove(E element)
	{
		for(int i = 0; i < this.size; i++)
		{
			if(this.items[i].equals(element))
				return this.removeAt(i);
		}
		return this;
	}
	
	public boolean contains(E element)
	{
		for(Object item : this.items)
			if(item.equals(element))
				return true;
		
		return false;
	}
	
	public int indexOf(E element)
	{
		for(int i = 0; i < this.size; i++)
			if (this.items[i].equals(element))
				return i;
		return -1;
	}
}
