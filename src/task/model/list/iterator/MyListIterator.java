package task.model.list.iterator;

public interface MyListIterator<E> {

	boolean hasNext();

	E next();

	public boolean hasPrevious();

	public E previous();

	void set(E e);
	
	public int nextIndex();

	public int previousIndex();
}
