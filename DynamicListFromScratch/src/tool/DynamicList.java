package tool;

import static java.lang.System.out;

import java.util.List;

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
	
	void increaseCapacity()
	{
		int oldCapacity = this.items.length;
		int newCapacity = (oldCapacity * 3) / 2 + 1;
		
		Object[] newItems = new Object[newCapacity];
		
		for(int i = 0; i < size; i++)
			newItems[i] = this.items[i];
		
		this.items = newItems;
	}
	
	public DynamicList<E> add(E item)
	{
		if(this.size == this.items.length)
		{
			this.increaseCapacity();
		}
		items[size++] = item;
		return this;
	}
	
	@Override
	public String toString() {
		if(this.size == 0)
			return "[]";
		String result = "[";
		int i;
		for (i = 0; i < this.size - 1; i++)
		{
			result += this.items[i] + ", ";
		}
		result += this.items[i] + "]";
		return result;
	}
	
	public Object get(int index)
	{
		if(index >= this.size)
			throw new ArrayIndexOutOfBoundsException(index);
		
		return this.items[index];
	}
	
	public Object first()
	{
		return this.get(0);
	}
	
	public DynamicList<E> set(int index, E item)
	{
		if(index < 0 || index >= this.size)
			return this;
		this.items[index] = item;
		return this;
	}
	
	public 	Object removeAt(int index)
	{
		if (index >= this.size || index < 0)
			throw new ArrayIndexOutOfBoundsException(index);
		Object temp = this.items[index];
		for(int i = index; i < this.size - 1; i++)
			this.items[i] = this.items[i + 1];
		
		this.size--;
		
		return temp;
	}
	
	public Object remove(E element)
	{
		return this.removeAt(this.indexOf(element));
	}
	
	public Object removeLast()
	{
		return this.removeAt(this.size - 1);
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
	
	public int lastIndexOf(E element)
	{
		for(int i = this.size - 1; i >= 0; i--)
			if (this.items[i].equals(element))
				return i;
		
		return -1;
	}
	
	public void clear()
	{
		this.items = new Object[this.items.length];
		this.size = 0;
	}
	
	public int count(Object element)
	{
		int counter = 0;
		
		for(Object item : this.items)
			if(item == element)
				counter++;
		
		return counter;
	}
	
	public boolean isEmpty()
	{
		return (this.size == 0) ? true : false;
	}
	
	public boolean isNotEmpty()
	{
		return (this.isEmpty()) ? false : true;
	}
	
	public Object last()
	{
		return  this.items[this.size - 1];
	}
	
	public DynamicList<E> reversed()
	{
		Object[] newList = new Object[this.items.length];
		for(int i = this.size - 1, j = 0; i >= 0; i--, j++)
		{
			newList[j] = this.items[i];
		}
		this.items = newList;
		
		return this;
	}
	
	public void insert(int index, Object element)
	{
		if (index >= this.size || index < 0)
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		
		if(this.size == this.items.length)
		{
			this.increaseCapacity();
		}
		
		for(int i = this.size; i > index; i--)
		{
			this.items[i] = this.items[i - 1];
		}
		
		this.items[index] = element;
		
		this.size++;
		
	}
	
	public boolean equals(DynamicList<E> list) 
	{
		
		if(this.size != list.size)
			return false;
		
		for(int i = 0; i < this.size; i++)
		{
			if(this.items[i] != list.get(i))
				return false;
		}
		return true;
	}
	
	public boolean equals(List<E> list)
	{
		if(this.size != list.size())
			return false;
		
		for(int i = 0; i < this.size; i++)
		{
			if(this.items[i] != list.get(i))
				return false;
		}
		return true;
	}
	
}
