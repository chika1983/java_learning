package com.practice.threads.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSet<E> extends ForwardingSet<E>
{
	public ObservableSet(Set<E> set) 
	{ 
		super(set); 
	}
	
	private final List<SetObserver<E>> observers =
	new ArrayList<SetObserver<E>>();
	
	public void addObserver(SetObserver<E> observer) 
	{
		synchronized(observers) 
		{
			observers.add(observer);
		}
	}
	
	public boolean removeObserver(SetObserver<E> observer) 
	{
		synchronized(observers) 
		{
			return observers.remove(observer);
		}
	}
	
	private void notifyElementAdded(E element) 
	{
		System.out.println("Inside notifyElement Added method");
		List<SetObserver<E>> snapshot = null;
		synchronized(observers) {
		snapshot = new ArrayList<SetObserver<E>>(observers);
		}
		for (SetObserver<E> observer : snapshot)
		observer.added(this, element);
	}
	
	@Override public boolean add(E element) 
	{
		boolean added = super.add(element);
		if (added)
		notifyElementAdded(element);
		return added;
	}
	
	@Override public boolean addAll(Collection<? extends E> c) 
	{
		boolean result = false;
		for (E element : c)
		result |= add(element); // calls notifyElementAdded
		return result;
	}
	
	public static void main(String[] args) 
	{
		ObservableSet<Integer> set =
		new ObservableSet<Integer>(new HashSet<Integer>());
		
		// Observer that uses a background thread needlessly
		set.addObserver(new SetObserver<Integer>() {
		public void added(final ObservableSet<Integer> s, Integer e) {
		System.out.println(e);
		if (e == 23) {
		ExecutorService executor =
		Executors.newSingleThreadExecutor();
		final SetObserver<Integer> observer = this;
		try {
		executor.submit(new Runnable() {
		public void run() {
			System.out.println("Remove Observer");
		s.removeObserver(observer);
		}
		}).get();
		} catch (ExecutionException ex) {
		throw new AssertionError(ex.getCause());
		} catch (InterruptedException ex) {
		throw new AssertionError(ex.getCause());
		} finally {
		executor.shutdown();
		}
		}
		}
		});
		for (int i = 0; i < 100; i++)
			set.add(i);
		}
}
