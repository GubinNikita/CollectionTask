package task.model.list.impl;

import java.util.Arrays;
import java.util.Objects;

import task.model.list.MyList;
import task.model.list.iterator.MyListIterator;

public class MyArrayListImpl<E> implements MyList<E> {

	private Object[] array;

	private final static int DEFAULT_SIZE = 16;

	private final static int CUT_MOD = 4;

	private int size;

	public MyArrayListImpl() {
		array = new Object[DEFAULT_SIZE];
	}

	public MyArrayListImpl(int initialCapacity) {
		if (initialCapacity > 0) {
			array = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			array = new Object[DEFAULT_SIZE];
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	public MyArrayListImpl(MyList<? extends E> c) {
		Object[] cArray = c.toArray();
		size = cArray.length;
		if (size != 0) {
			array = Arrays.copyOf(cArray, size);
		} else {
			array = new Object[DEFAULT_SIZE];
		}
	}

	@Override
	public void add(E e) {
		if (size == array.length - 1) {
			resize(array.length * 2);
		}
		array[size++] = e;
	}

	@Override
	public E get(int index) {
		Objects.checkIndex(index, size);
		return (E) array[index];
	}

	@Override
	public void remove(int index) {
		Objects.checkIndex(index, size);
		for (int i = index; i < size - 1; i++)
			array[i] = array[i + 1];
		array[--size] = null;
		if (array.length > DEFAULT_SIZE && size < array.length / CUT_MOD)
			resize(array.length / 2);
	}

	@Override
	public void addAll(MyList<? extends E> c) {
		Object[] cArray = c.toArray();
		int cArrayLenght = cArray.length;
		if (cArrayLenght == 0)
			return;
		if (cArrayLenght > (array.length - size)) {
			resize(size + cArrayLenght);
		}
		System.arraycopy(cArray, 0, array, size, cArrayLenght);
		size += cArrayLenght;
	}

	@Override
	public void set(int index, E e) {
		Objects.checkIndex(index, size);
		array[index] = e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public MyListIterator<E> iterator() {
		return new ListItr();
	}

	private class ListItr implements MyListIterator<E> {

		private int index = 0;

		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			lastRet = index;
			return (E) array[index++];
		}

		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		@Override
		public E previous() {
			if (!hasPrevious()) {
				throw new IndexOutOfBoundsException();
			}
			lastRet = index;
			return (E) array[--index];
		}

		@Override
		public void set(E e) {
			if (lastRet < 0)
				throw new IllegalStateException();

			MyArrayListImpl.this.set(lastRet, e);
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public String toString() {
		Object[] arrayToString = Arrays.copyOf(array, size);
		return Arrays.toString(arrayToString);
	}

	private void resize(int newLength) {
		Object[] newArray = new Object[newLength];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
	}

}
