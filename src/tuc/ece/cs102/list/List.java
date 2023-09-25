package tuc.ece.cs102.list;

public class List {

	protected Node head;

	protected int length;

	public List() {
		head = null;
		length = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node insert(Item a) {
		length++;
		head = new Node(a, head);
		return head;
	}

	public int getLength() {
		return length;
	}

	public void clearList() {
		head = null;
		length = 0;
	}

	public void print() {
		int counter = 0;
		for (Node tmp = head; tmp != null; tmp = tmp.getNext()) {
			System.out.print("[" + counter + "] ");
			tmp.print();
			counter++;
		}
		if (counter == 0) {
			System.out.println("Empty List...");
		} else {
			System.out.println("==================================");
		}

	}

	public Node search(Item a) {
		for (Node tmp = head; tmp != null; tmp = tmp.getNext()){
			if (a.equals(tmp.getValue())){
				return tmp;
			}
		}
		return null;
	}

	public Node delete(Item i) {
		Node current = head, prev = head;

		while ((current != null) && (!i.equals(current.getValue()))) {

			prev = current;
			current = current.getNext();
		}
		if (current != null) {
			length--;
			if (prev != current)
				prev.setNext(current.getNext());
			else
				head = head.getNext();
			current.setNext(null);
		}
		return head;
	}

	public Item removeFirst() {
		Node tmp = head;

		if (head != null) {
			length--;
			head = head.getNext();
			tmp.setNext(null);
			return tmp.getValue();
		} else
			return null;
	}

}
