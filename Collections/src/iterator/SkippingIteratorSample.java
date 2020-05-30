package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


class SkippingIterator<T> implements Iterator<T> {
	private List<T> list;
	private int currentPosition;
	private int skipBy;

	public SkippingIterator(List<T> l) {
		this(l, 2);
	}

	public SkippingIterator(List<T> l, int skip) {
		this(l, skip, 0);
	}

	public SkippingIterator(List<T> l, int skip, int startPosition) {
		list = l;
		skipBy = skip;
		currentPosition = startPosition;
	}

	@Override
	public boolean hasNext() {
		return currentPosition < list.size();
	}

	@Override
	public T next() {
		T result = list.get(currentPosition);
		currentPosition += skipBy;
		return result;
	}
}




public class SkippingIteratorSample {
	public static void main (String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		Iterator it = new SkippingIterator<Integer>(list);

		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}