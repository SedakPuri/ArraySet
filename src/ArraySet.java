import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<E> implements Set<E>, Iterable<E> {
	ArrayList<E> theSet;

	public ArraySet() {
		theSet = new ArrayList<> ();
	}

	@Override
	public boolean add(E k) {
		if (theSet.contains(k)) {
			return false;
		}
		theSet.add(k);
		return true;
	}

	@Override
	public boolean remove(E k) {
		return theSet.remove(k);
	}

	@Override
	public boolean contains(E k) {
		return theSet.contains(k);
	}

	@Override
	public Iterator<E> iterator() {
		return theSet.iterator();
	}

	@Override
	public void addAll(Set<E> other) {
		Iterator<E> it = other.iterator();

		while(it.hasNext()) {				//Union
			this.add(it.next());				//Keep adding and it invokes the add method of this class (already checks for duplicates).
		}
	}

	@Override
	public void retainAll(Set<E> other) {
		Iterator<E> it = other.iterator();

		while(it.hasNext()) {
			E k = it.next();					//Intersection!!!
			if (!contains(k)) {
				remove(k);					//Remove if it isn't contained in both
			}
		}
	}

	@Override
	public void removeAll(Set<E> other) {
		Iterator<E> it = other.iterator();

		while(it.hasNext()) {
			E k = it.next();					//Subtraction!!!
			if (contains(k)) {
				remove(k);					//Remove if it overlaps with other
			}
		}
	}

}
