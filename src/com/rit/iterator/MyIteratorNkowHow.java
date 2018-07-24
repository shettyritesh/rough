package com.rit.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIteratorNkowHow <E>{
	private E[] arr;
	public MyIteratorNkowHow(E[] thatarr){
		arr=thatarr;
	}
	public Iterator<E> iterator(){
		Iterator<E> iter=null;
		return new MyListIterator(arr);
		

	}
}

class MyListIterator<E> implements Iterator<E>{
	private int pointer=0;
	private E[] arr;
	public MyListIterator(E[] thatarr) {
		arr=thatarr;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return (pointer<arr.length-1?true:false);
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		if(pointer<arr.length)
		{
			return arr[pointer++];
		}
		throw new NoSuchElementException();
	}
	
}
