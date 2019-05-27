package CTCI_Linked_Lists;

import java.util.HashSet;

public class intersection_2_7 {

	public static Node intersectHashSet(SingleLinkedList a, SingleLinkedList b) {
		HashSet<Node> hs = new HashSet<Node>();
		Node n1 = a.head;
		Node n2 = b.head;
		while(n1!=null) {
			hs.add(n1);
			n1 = n1.next;
		}
		while(n2!=null) {
			if(hs.contains(n2)) {
				return n1;
			}
		}


		return  null;
	}

//	public static Node intersect(SingleLinkedList a, SingleLinkedList b) {
//
//	}
//
//	public static void main(String[] args) {
//
//	}
}
