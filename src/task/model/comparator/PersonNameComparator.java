package task.model.comparator;

import java.util.Comparator;

import task.model.entity.Person;

public class PersonNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person firstPerson, Person secondPerson) {
		return firstPerson.getName().compareTo(secondPerson.getName());
	}

}
