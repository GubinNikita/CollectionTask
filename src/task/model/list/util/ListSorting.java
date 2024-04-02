package task.model.list.util;

import java.util.Comparator;

import task.model.list.MyList;
import task.model.list.iterator.MyListIterator;

public class ListSorting {

	public static <T> void sort(MyList<T> list, Comparator<? super T> comparator) {
		Object[] listArray = list.toArray();
		boolean isSorted = isSorted(list, comparator);

		if (isSorted) {
			return;
		}

		for (int i = 0; i < listArray.length - 1; i++) {
			for (int j = listArray.length - 1; j > i; j--) {
				if (comparator.compare((T) listArray[j - 1], (T) listArray[j]) > 0) {
					Object tmp = listArray[j - 1];
					listArray[j - 1] = listArray[j];
					listArray[j] = tmp;
				}
			}
		}

		replaceValues(list, listArray);
	}

	private static <T> void replaceValues(MyList<T> list, Object[] array) {
		MyListIterator<T> iterator = list.iterator();

		for (Object o : array) {
			iterator.next();
			iterator.set((T) o);
		}
	}

	private static <T> boolean isSorted(MyList<T> list, Comparator<? super T> comparator) {
		Object[] listArray = list.toArray();
		boolean result = true;

		for (int i = 0; i < listArray.length; i++) {
			if (comparator.compare((T) listArray[i], (T) listArray[i + 1]) > 0) {
				result = false;
				break;
			}
		}

		return result;
	}
}
