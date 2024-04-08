package task.model.comparator;

import java.util.Comparator;

import task.model.entity.Person;
import task.model.entity.PersonFieldsEnum;

public class PersonComparator implements Comparator<Person> {
	private PersonFieldsEnum sortingIndex;

	public PersonComparator(PersonFieldsEnum sortingIndex) {
		setSortingIndex(sortingIndex);
	}

	public void setSortingIndex(PersonFieldsEnum sortingIndex) {
		if (sortingIndex == null) {
			throw new IllegalArgumentException();
		}
		this.sortingIndex = sortingIndex;
	}

	public PersonFieldsEnum getSortingIndex() {
		return sortingIndex;
	}

	@Override
	public int compare(Person o1, Person o2) {
		switch (sortingIndex) {
		case AGE:
			return Integer.compare(o1.getAge(), o2.getAge());
		case NAME:
			return o1.getName().compareTo(o2.getName());
		default:
			throw new EnumConstantNotPresentException(PersonFieldsEnum.class, sortingIndex.name());
		}
	}

}
