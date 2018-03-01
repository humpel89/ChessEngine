package model.chess;

public interface Stack<E> {
	
	public E push(E e);

	public E pop() throws StackIsEmptyException;
	
	public E top() throws StackIsEmptyException;
	
	public boolean isEmpty();
}
