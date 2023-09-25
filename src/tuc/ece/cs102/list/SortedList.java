package tuc.ece.cs102.list;

public class SortedList extends List {

	@Override
	public Node insert(Item a) {
		Node tmp = new Node(a);
		length++;
		Node current = head, prev = head;

		while ((current != null) && (current.getValue().less(a))) {
			prev = current;
			current = current.getNext();
		}
		if (current == head) {
			tmp.setNext(current);
			head = tmp;
		} else {
			prev.setNext(tmp);
			tmp.setNext(current);
		}
		return head;
	}

}
