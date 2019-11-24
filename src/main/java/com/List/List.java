package com.List;

class Node {
	byte data;
	
	public Node next;
	public Node prev;
}

class List {
	
	public void Print(Node head) {
		for (Node p = head; p != null; p = p.next) {
			System.out.print(p.data + " ");
		}
		System.out.println();
	}
	
	public int Amount(Node head) {
		int result = 0;
		for (Node p = head; p != null; p = p.next) {
			result++;
		}
		return result;
	}
	
}

class Stack {
	public Node head = null;
	
	public void Insert(Node p, byte data) {
		if (head == null) {
			p = new Node();
			p.data = data;
			head = p;
			head.next = null;
		}
		else
		{
			p = new Node();
			p.data = data;
			p.next = head;
			head = p;	
		}
	}
}

class Queue {
	public Node head = null;
	public Node tail = null;
	public Node p;
		
	public void Insert(Node p, byte data) {
		if (head == null) {
			p = new Node();
			p.data = data;
			head = tail = p;
			head.next = null;
			head.prev = null;
		}
		else { 
			p = new Node();
			p.data = data;
			p.prev = tail;
			tail.next = p;
			tail = p;
			tail.next = null;
		}
	}
	
	public boolean AddOneElement(Node head, byte data, byte k) {
			
		for (p = head; p != null; p = p.next) {
			if (k == p.data) {
				if (p.next != null) {	
					 Node tmp = new Node();
					 tmp.data = data;
					 tmp.next = p.next;
					 p.next.prev = tmp;
					 p.next = tmp;
					 tmp.prev = p;
					 return false;
				}
				else {
					Node temp = new Node();
					temp.data = data;
					temp.prev = tail;
					tail.next = temp;
					tail = temp;
					return false;
				}	
			}
		}
		return true;
	}
	
	
	public boolean MoveElements(Node head, byte a, byte b) {
		int position = 1;
		int pos1 = 0, pos2 = 0;
		Node one = null, two = null;
		Node t = new Node();
		
		for (Node p = head; p != null; p = p.next) {
			if (one == null && (a == p.data) && (two != p)) {
				one = p;
				if (pos1 == 0)
					pos1 = position;
				else
					pos2 = position;
			}
			if ((two == null) && (b == p.data) && (one != p)) {
				two = p;
				if (pos1 == 0)
					pos1 = position;
				else
					pos2 = position;
			}		
			++position;
		}
	//	System.out.print(pos1 + " " + pos2);
		
		if (pos1 == 0 || pos2 == 0)
			return true;
		
			
		if (one.next != two) {	
			t.next = one.next;
			t.prev = one.prev;
		
			one.next = two.next;
			one.next.prev = two;
			one.prev.next = two;
			one.prev = two.prev;
			two.prev.next = one;
			
			two.next = t.next;
			two.prev = t.prev;
		} else {
			one.next = two.next;
			two.next.prev = one;
			two.next = one;
			two.prev = one.prev;
			one.prev = two;
			two.prev.next = two;
		}
	
		return false;
	}
	
	public void DeleteDuplicateItems(Node head) {
		for (Node p = head; p.next != null; p = p.next) {
			for (Node q = p.next; q != null; q = q.next) {
				if (p.data == q.data) {
					if (q.next != null) {
						Node t = q;
						t.prev.next = t.next;
						t.next.prev = t.prev;
						t = null;
					}
					else {
						Node t = q;
						t.prev.next =null;
						t.prev = null;
						t = null;
					}
				}
			}
		}
	}
}



class Main {
	public static void main(String args[]) {
		Queue q = new Queue();
		Stack s = new Stack();
		List list = new List();
		
		Node p = null;
		byte[] a = {3, 3, 3, 4, 5, 5, 5 , 3, 4, 3, 4, 16, 25 , 9, 16, 25};
		
		for (int i = 0; i < a.length; i++) {
			if ((Math.sqrt(a[i]) % 0.5) == 0) {
				q.Insert(p, a[i]);
				s.Insert(s.head, a[i]);
			}
				
		}
		System.out.print("������� com.List.Queue: ");
		list.Print(q.head);
		System.out.print("������� com.List.Stack: ");
		list.Print(s.head);
		
		byte k = 2;
		if (q.AddOneElement(q.head, k, k))
			System.out.print("��� ������ ��������");
		
		System.out.println("\n������� ������ �������� � com.List.Queue: ");
		q.DeleteDuplicateItems(q.head);
		list.Print(q.head);
		System.out.println("\n���������� ��������� � com.List.Queue: " + list.Amount(q.head));
		
		
		byte b = 1;

		s.head = null;
		q.head = null;
		
		for (int i = 0; i < 10; i++) {
			s.Insert(s.head, b);
			q.Insert(q.head, b);
			++b;
		}
		

//		q.MoveElements(q.head, k, g);
		
		
//		System.out.println();
//		list.Print(s.head);
//		System.out.println();
//		list.Print(q.head);
//		
//		

		
//			
		list.Print(q.head);
//		
		
		System.out.println();
		list.Print(q.head);
//		

		
		System.out.println("\n���������� ��������� � ������: " + list.Amount(q.head));
		
		//new Gui(s.head, q.head);
		
		
	}
}
