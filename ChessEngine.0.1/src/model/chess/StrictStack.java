package model.chess;

import java.util.LinkedList;
import java.util.List;

public class StrictStack<E> implements Stack<E> {

	private List<E> list;

	public StrictStack(){
		this.list = new LinkedList<E>();
	}

	public StrictStack(List<E> list){
		this.list = list;
	}

	@Override
	public E push(E e) {
		list.add(e);
		return e;
	}

	@Override
	public E pop() throws StackIsEmptyException {
		if (isEmpty()) 
			throw new StackIsEmptyException("Tried to pop when stack was empty");
		else {
			int lastElement = list.size() - 1;
			return list.remove(lastElement);
		}
	}

	@Override
	public E top() throws StackIsEmptyException {
		if (isEmpty()) 
			throw new StackIsEmptyException("Tried to top when stack was empty");
		else {
			int lastElement = list.size() - 1;
			return list.get(lastElement);
		}
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
