package com.practice.threads.general;

public interface SetObserver<E> 
{
	void added(ObservableSet<E> set, E element);

}
