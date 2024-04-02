package task.model.list;

import task.model.list.iterator.MyListIterator;

public interface MyList<E> {

	void add(E e);

	E get(int index);

	void remove(int index);

	void addAll(MyList<? extends E> c);

	void set(int index, E e);

	int size();

	MyListIterator<E> iterator();

	Object[] toArray();
}
