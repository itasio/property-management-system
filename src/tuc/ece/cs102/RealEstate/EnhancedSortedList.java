package tuc.ece.cs102.RealEstate;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.list.SortedList;

public class EnhancedSortedList extends SortedList {
	public EnhancedSortedList() {
		super();
	}
	
	public Item search(int key){
		Node tmpNode = head;
		while (tmpNode != null){
			if (tmpNode.getValue().key().equals(new Integer(key))){
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}

	public Item search(long key){
		Node tmpNode = head;
		while (tmpNode != null){
			if (tmpNode.getValue().key().equals(new Long(key))){
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}

	public void printItemsInHierarchy(String ClassName) {
		Node tmp= head;
		try {
			while(tmp != null) {
				Item item = tmp.getValue();
				if( Class.forName(ClassName).isInstance(item.getData()) ) {
					item.print();
				}
				tmp = tmp.getNext();
			}				
		}catch(ClassNotFoundException ex){
			System.out.println("Class: "+ClassName+" does not exist.");
		}
	}
	
	public Node getHead() {
		return head;
	}
}
