package com.practice.threads.general;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> 
{
	private final Set<E> s;
	
	public ForwardingSet(Set<E> s)
	{
		System.out.println("ForwardingSet Constructor");
		this.s = s;
	}

	public void clear()
	{
		System.out.println("Forwarding Set >> Inside Method clear");
		s.clear();
	}
	
	public boolean contains(Object o)
	{
		System.out.println("Forwarding Set >> Inside Method contains");
		return s.contains(o);
	}
	
	public boolean isEmpty()
	{
		System.out.println("Forwarding Set >> Inside Method isEmpty");
		return s.isEmpty();
	}
	
	public int size()
	{
		System.out.println("Forwarding Set >> Inside Method size");
		return s.size();
	}
	
	public Iterator<E> iterator()
	{
		System.out.println("Forwarding Set >> Inside Method iterator");
		return s.iterator();
	}
	
	public boolean add(E e)
	{
		System.out.println("Forwarding Set >> Inside Method add");
		return s.add(e);
	}
	
	public boolean remove(Object o)
	{
		System.out.println("Forwarding Set >> Inside Method remove");
		return s.remove(o);
	}
	
	public boolean containsAll(Collection<?> c)
	{
		System.out.println("Forwarding Set >> Inside Method containsAll");
		return s.containsAll(c);
	}
	
	public boolean addAll(Collection<? extends E> c)
	{ 
		System.out.println("Forwarding Set >> Inside Method addAll");
		return s.addAll(c); 
	}
	
	public boolean removeAll(Collection<?> c)
	{ 
		System.out.println("Forwarding Set >> Inside Method removeAll");
		return s.removeAll(c); 
	}
	
	public boolean retainAll(Collection<?> c)
	{
		System.out.println("Forwarding Set >> Inside Method retainAll");
		return s.retainAll(c); 
	}
	
	public Object[] toArray() 
	{ 
		System.out.println("Forwarding Set >> Inside Method toArray");
		return s.toArray(); 
	}
	
	public <T> T[] toArray(T[] a) 
	{ 
		System.out.println("Forwarding Set >> Inside Method generic toArray");
		return s.toArray(a); 
	}
	@Override public boolean equals(Object o)
	{ 
		System.out.println("Forwarding Set >> Inside Method equals");
		return s.equals(o); 
	}
	
	@Override public int hashCode() 
	{ 
		System.out.println("Forwarding Set >> Inside Method hashCode");
		return s.hashCode(); 
	}
	
	@Override public String toString() 
	{ 
		System.out.println("Forwarding Set >> Inside Method toString");
		return s.toString(); 
	}
	
}
