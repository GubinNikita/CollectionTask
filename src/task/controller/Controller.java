package task.controller;

import task.model.comparator.PersonComparator;
import task.model.entity.Person;
import task.model.entity.PersonFieldsEnum;
import task.model.list.MyList;
import task.model.list.impl.MyArrayListImpl;
import task.model.list.iterator.MyListIterator;
import task.model.list.util.ListSorting;
import task.view.Printer;

public class Controller {
	public static void main(String[] args) {
		MyList<Person> list1 = new MyArrayListImpl<>();
		MyList<Person> list2 = new MyArrayListImpl<>();

		list1.add(new Person("Ivan", 4));
		list1.add(new Person("Vladimir", 9));
		list1.add(new Person("Alexander", 2));
		list1.add(new Person("Oleg", 10));
		list1.add(new Person("Maxim", 30));

		MyList<Person> list = new MyArrayListImpl<>(list1);

		list2.add(new Person("Gregoriy", 18));
		list2.add(new Person("Pavel", 20));

		list.remove(4);
		list.addAll(list2);
		list.set(0, new Person("Genadiy", 19));

		Printer.print(list.size());
		Printer.print(list.get(4));
		Printer.print(list.get(0));

		ListSorting.sort(list, new PersonComparator(PersonFieldsEnum.NAME));

		Printer.print("Sort by name:");
		MyListIterator<Person> iterator = list.iterator();

		while (iterator.hasNext()) {
			Printer.print(iterator.next());
		}

		Printer.print("----------------------------------------------------");

		ListSorting.sort(list, new PersonComparator(PersonFieldsEnum.AGE));

		Printer.print("Sort by age:");
		iterator = list.iterator();

		while (iterator.hasNext()) {
			Printer.print(iterator.next());
		}
	}
}
