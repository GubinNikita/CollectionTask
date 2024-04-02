package task.model.comparator;

import java.util.Comparator;

import task.model.entity.Person;

public class PersonAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person firstPerson, Person secondPerson) {
		return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
	}

}
